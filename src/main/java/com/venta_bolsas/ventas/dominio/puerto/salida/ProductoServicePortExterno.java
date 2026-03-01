package com.venta_bolsas.ventas.dominio.puerto.salida;

import com.venta_bolsas.ventas.dominio.modelo.ProductoDto;

public interface ProductoServicePortExterno {
    ProductoDto saveProducto(ProductoDto producto);
    ProductoDto findCodigoBarrasAndNombre(String codigoBarras, String nombre);
}
