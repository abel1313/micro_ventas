package com.venta_bolsas.ventas.dominio.puerto.entrada;

import com.venta_bolsas.ventas.adaptador.entrada.dto.DetalleVentaDto;
import com.venta_bolsas.ventas.adaptador.entrada.dto.TotalDetalle;
import com.venta_bolsas.ventas.dominio.modelo.Venta;

import java.util.List;

public interface GuardarVentaPort {
    void guardarVenta(Venta venta);
    Venta saveVentaDetalle(List<DetalleVentaDto> detall);
    List<TotalDetalle> getTotalDetalle();
}
