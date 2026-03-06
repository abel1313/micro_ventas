package com.venta_bolsas.ventas.dominio.formaPago;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class IvaTerminal {
    private Integer id;
    private Double iva;
    private String descripcion;
}
