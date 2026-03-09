package com.venta_bolsas.ventas.aplicacion.out;

import com.venta_bolsas.ventas.dominio.modelo.Usuario;

import java.util.Optional;

public interface UsuarioPortOut {

    Optional<Usuario> findById(Integer id);
}
