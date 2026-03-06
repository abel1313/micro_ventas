package com.venta_bolsas.ventas.aplicacion.out;

import com.venta_bolsas.ventas.dominio.formaPago.DetallePago;
import com.venta_bolsas.ventas.dominio.modelo.ResponseGeneric;
import reactor.core.publisher.Mono;

import java.util.Optional;

public interface PagosPortOut {

    Mono<ResponseGeneric<Optional<DetallePago>>> obtenerDetallePago(Integer tipoPago,
                            Integer tarifaTerminalId,
                            Integer ivaId);
}
