package com.venta_bolsas.ventas.dominio.formaPago;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Schema(description = "Entidad de la terminal")
public class TarifaTerminal {
    @Schema(description = "ID de la tarifa", example = "1")
    private Integer id;
    @Schema(description = "Tarifa", example = "1.0")
    private Double tarifa;
    @Schema(description = "Descripcion", example = "terminal")
    private String descripcion;
}

