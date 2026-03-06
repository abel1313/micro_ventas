package com.venta_bolsas.ventas.aplicacion.out;

import com.venta_bolsas.ventas.dominio.formaPago.DetallePago;
import com.venta_bolsas.ventas.dominio.formaPago.Venta;


public interface VentaRepositoryJpaOut {

    Venta saveUseCaseRepo(Venta venta, DetallePago detallePago);
}
