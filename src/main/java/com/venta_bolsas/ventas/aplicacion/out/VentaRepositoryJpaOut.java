package com.venta_bolsas.ventas.aplicacion.out;

import com.venta_bolsas.ventas.dominio.formaPago.DetallePago;
import com.venta_bolsas.ventas.dominio.formaPago.Venta;
import com.venta_bolsas.ventas.dominio.modelo.PageDto;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;


public interface VentaRepositoryJpaOut {

    Venta saveOut(Venta venta, DetallePago detallePago);
    Venta updateOut(Venta venta, DetallePago detallePago);
    Venta findByIdUOut(Integer idVenta);
    PageDto<Venta> findAllOut(Integer page, Integer size);
}
