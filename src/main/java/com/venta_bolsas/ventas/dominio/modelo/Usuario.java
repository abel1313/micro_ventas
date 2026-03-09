package com.venta_bolsas.ventas.dominio.modelo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Objects;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Schema(description = "Entidad que describe al usuario")
public class Usuario {

    @Schema(description = "ID de usuario", example = "1")
    private Integer idUsuario;
    @Schema(description = "Nombre de usuario", example = "Juan")
    private String nombre;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(idUsuario, usuario.idUsuario) && Objects.equals(nombre, usuario.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, nombre);
    }
}
