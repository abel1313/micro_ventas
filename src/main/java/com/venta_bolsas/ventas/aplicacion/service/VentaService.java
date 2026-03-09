package com.venta_bolsas.ventas.aplicacion.service;

import com.venta_bolsas.ventas.aplicacion.in.VentaUserCase;
import com.venta_bolsas.ventas.aplicacion.out.VentaRepositoryJpaOut;
import com.venta_bolsas.ventas.dominio.exceptions.DetallePagoNotFound;
import com.venta_bolsas.ventas.dominio.exceptions.ExceptionDuplicado;
import com.venta_bolsas.ventas.dominio.exceptions.UsuarioNotFound;
import com.venta_bolsas.ventas.dominio.formaPago.*;
import com.venta_bolsas.ventas.dominio.modelo.PageDto;
import com.venta_bolsas.ventas.dominio.modelo.ResponseGeneric;
import com.venta_bolsas.ventas.dominio.modelo.Usuario;
import com.venta_bolsas.ventas.infraestructura.client.PagoAdapter;
import com.venta_bolsas.ventas.infraestructura.client.UsuarioAdapter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
@AllArgsConstructor
@Slf4j
public class VentaService implements VentaUserCase {

    private final VentaRepositoryJpaOut ventaRepositoryJpaOut;
    private final PagoAdapter pagoAdapter;
    private final UsuarioAdapter usuarioAdapter;
    @Override
    public Venta saveUseCase(Venta venta) {
        log.info("Llegamos al servicio para ir a la base de datos {}", venta);
        DetallePago detallePago = venta.getDetallePago();
        TipoPago tipoPago = detallePago.getTipoPago();
        TarifaTerminal tarifaTerminal = detallePago.getTarifaTerminal();
        IvaTerminal  ivaTerminal = detallePago.getIvaTerminal();

        Mono<ResponseGeneric<Optional<DetallePago>>> responseGenericMono = this.pagoAdapter
                .obtenerDetallePago(tipoPago.getId(),
                        tarifaTerminal.getId(),
                        ivaTerminal.getId())
                .flatMap(responsePagos->{
                    DetallePago  responseGeneric = responsePagos.getResponse().orElseThrow(()-> new RuntimeException("Ocurrio un error"));
                    venta.setDetallePago(responseGeneric);
                    this.ventaRepositoryJpaOut.saveOut(venta, detallePago);
                    return Mono.just(responsePagos);
                });


        return this.ventaRepositoryJpaOut.saveOut(venta, detallePago);
    }

    @Override
    public Venta updateUseCase(Venta venta) {
        Venta existeVenta = this.ventaRepositoryJpaOut.findByIdUOut(venta.getId());
        Usuario usuario = Optional.ofNullable(existeVenta.getUsuario()).orElseThrow(()-> new UsuarioNotFound("El usuario no existe"));
        DetallePago detallePago = Optional.ofNullable(venta.getDetallePago()).orElseThrow(()-> new DetallePagoNotFound("El detalle de pago no existe"));
        existeVenta.setDetallePago(detallePago);
        existeVenta.setUsuario(usuario);
        existeVenta.setEstadoVenta(venta.getEstadoVenta());
        existeVenta.setTotalVenta(venta.getTotalVenta());
        return saveUseCase(existeVenta);
    }

    @Override
    public Venta findByIdUseCase(Integer idVenta) {
        return this.ventaRepositoryJpaOut.findByIdUOut(idVenta);
    }

    @Override
    public PageDto<Venta> findAllUserCase(Integer page, Integer size) {
        PageDto<Venta> pageDto = this.ventaRepositoryJpaOut.findAllOut(page, size);
        List<Venta> listVenta = pageDto.getContenido()
                .stream()
                .peek(mapper->{
                    Optional<Usuario> usr = this.usuarioAdapter.findById(mapper.getUsuario().getIdUsuario());
                    mapper.setUsuario(usr.orElseThrow(()-> new ExceptionDuplicado("El usuario no existe")));

                    DetallePago det = mapper.getDetallePago();
                    TipoPago tip = det.getTipoPago();
                    TarifaTerminal tar = det.getTarifaTerminal();
                    IvaTerminal  ivaTerminal = det.getIvaTerminal();
                    Mono<ResponseGeneric<Optional<DetallePago>>> mono = this.pagoAdapter.obtenerDetallePago(tip.getId(),
                                                        tar.getId(),
                                                        ivaTerminal.getId());
                    det = mono.map(flta-> flta.getResponse().orElseThrow(()-> new RuntimeException("Ocxuirrio un error"))).block();
                    mapper.setDetallePago(det);

                }).toList();
        pageDto.setContenido(listVenta);
        return pageDto;
    }
    @Async
    public CompletableFuture<String> tareaAsincrona() {
        SecurityContext ctx = SecurityContextHolder.getContext();
        log.info("Contexto en hilo secundario: {}", ctx);
        return CompletableFuture.completedFuture("respuesta asincrónica con JWT");
    }
}
