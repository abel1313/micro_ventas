package com.venta_bolsas.ventas.dominio.exceptions;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class MensajeError {

    private int code;
    private String message;
    private String fecha;
}
