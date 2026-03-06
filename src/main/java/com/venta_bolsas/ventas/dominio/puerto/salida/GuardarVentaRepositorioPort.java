package com.venta_bolsas.ventas.dominio.puerto.salida;

import com.venta_bolsas.ventas.aplicacion.entrada.dto.DetalleVentaDto;
import com.venta_bolsas.ventas.aplicacion.entrada.dto.TotalDetalle;
import com.venta_bolsas.ventas.dominio.modelo.Venta;

import java.util.List;

public interface GuardarVentaRepositorioPort {
    void guardar(Venta venta);
    Venta saveVentaDetallePortRepo(List<DetalleVentaDto> detall);
    List<TotalDetalle> getTotalDetallePortRepo();
}
