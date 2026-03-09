package com.venta_bolsas.ventas.aplicacion.in;

import com.venta_bolsas.ventas.dominio.formaPago.Venta;
import com.venta_bolsas.ventas.dominio.modelo.PageDto;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface VentaUserCase {

    Venta saveUseCase(Venta venta);
    Venta updateUseCase(Venta venta);
    Venta findByIdUseCase(Integer idVenta);
    PageDto<Venta> findAllUserCase(Integer page, Integer size);
    CompletableFuture<String> tareaAsincrona();

}
