package com.venta_bolsas.ventas.dominio.formaPago;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TarifaTerminal {
    private Integer id;
    private Double tarifa;
    private String descripcion;
}
