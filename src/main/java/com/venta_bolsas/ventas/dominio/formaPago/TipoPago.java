package com.venta_bolsas.ventas.dominio.formaPago;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Schema(description = "Entidad de la forma de pago")
public class TipoPago {

    @Schema(description = "ID de tipo de pago", example = "1")
    private Integer id;
    @Schema(description = "Forma de pago", example = "Efectivo")
    private String formaPago;
}
