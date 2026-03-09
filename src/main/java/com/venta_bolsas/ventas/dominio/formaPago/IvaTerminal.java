package com.venta_bolsas.ventas.dominio.formaPago;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Schema(description = "Entidad del Iva")
public class IvaTerminal {
    @Schema(description = "ID de la terminal", example = "1")
    private Integer id;
    @Schema(description = "Iva", example = "16")
    private Double iva;
    @Schema(description = "Iva", example = "iva")
    private String descripcion;
}
