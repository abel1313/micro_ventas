package com.venta_bolsas.ventas.aplicacion.entrada.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TotalDetalle {

    private BigDecimal id;
    private String nombreUsuario;
    private String nombreProducto;
    private BigDecimal cant;
    private BigDecimal precioUnitario;
    private BigDecimal subTotal;
    private BigDecimal total;


}
