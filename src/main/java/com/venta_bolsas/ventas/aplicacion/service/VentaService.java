package com.venta_bolsas.ventas.aplicacion.service;

import com.venta_bolsas.ventas.aplicacion.in.VentaUserCase;
import com.venta_bolsas.ventas.aplicacion.out.VentaRepositoryJpaOut;
import com.venta_bolsas.ventas.dominio.formaPago.*;
import com.venta_bolsas.ventas.dominio.modelo.ResponseGeneric;
import com.venta_bolsas.ventas.infraestructura.client.PagoAdapter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class VentaService implements VentaUserCase {

    private final VentaRepositoryJpaOut ventaRepositoryJpaOut;
    private final PagoAdapter pagoAdapter;
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
                    this.ventaRepositoryJpaOut.saveUseCaseRepo(venta, detallePago);
                    return Mono.just(responsePagos);
                });


        return this.ventaRepositoryJpaOut.saveUseCaseRepo(venta, detallePago);
    }

}
