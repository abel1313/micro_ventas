package com.venta_bolsas.ventas.dominio.formaPago;

import com.venta_bolsas.ventas.dominio.modelo.Usuario;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Schema(description = "Entidad que describe la venta")
public class Venta {


    @Schema(description = "ID de la venta", example = "1")
    private Integer id;

    private Usuario usuario;
    @Schema(description = "Total de la venta", example = "1.0")
    private Double totalVenta;
    private DetallePago detallePago;
    @Schema(description = "Estado de la venta", example = "pendiente")
    private String estadoVenta;
}
