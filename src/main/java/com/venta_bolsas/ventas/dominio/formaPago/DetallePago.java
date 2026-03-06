package com.venta_bolsas.ventas.dominio.formaPago;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DetallePago {

    private TipoPago tipoPago;
    private TarifaTerminal tarifaTerminal;
    private IvaTerminal ivaTerminal;
}
