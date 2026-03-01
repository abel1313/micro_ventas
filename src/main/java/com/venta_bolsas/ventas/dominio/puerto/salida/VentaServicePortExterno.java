package com.venta_bolsas.ventas.dominio.puerto.salida;

import com.venta_bolsas.ventas.dominio.modelo.Venta;

public interface VentaServicePortExterno {

    Venta saveVenta(Venta venta);
}
