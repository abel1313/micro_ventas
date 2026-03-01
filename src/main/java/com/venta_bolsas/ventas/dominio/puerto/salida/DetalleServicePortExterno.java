package com.venta_bolsas.ventas.dominio.puerto.salida;

import com.venta_bolsas.ventas.adaptador.entrada.dto.DetalleVentaDto;
import com.venta_bolsas.ventas.dominio.modelo.DetalleVentaModel;

import java.util.List;

public interface DetalleServicePortExterno {

    List<DetalleVentaModel> saveDetalleVenta(List<DetalleVentaModel> detalleVentaDto);
}
