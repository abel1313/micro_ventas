package com.venta_bolsas.ventas.adaptador.entrada.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetalleVentaDto {

    private String nombre;
    private String descripcion;
    private Integer stock;
    private Double precioVenta;
    private String codigoBarras;
    private Integer cantidad;
    private Double subTotal;
    private int pedidoId;
}
