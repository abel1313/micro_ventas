package com.venta_bolsas.ventas.dominio.modelo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Schema(description = "Entidad para paginar las ventas")
public class PageDto<T> {

    @Schema(description = "Pagina para buscar")
    private int page;
    @Schema(description = "Tamanio a buscar")
    private int size;
    @Schema(description = "Total de elemenotos")
    private int totalElementos;
    @Schema(description = "Contenido generico")
    private List<T> contenido;
}
