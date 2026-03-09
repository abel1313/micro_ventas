package com.venta_bolsas.ventas.dominio.exceptions;

public class VentaNotFound extends RuntimeException{
    public VentaNotFound(String message) {
        super(message);
    }
}
