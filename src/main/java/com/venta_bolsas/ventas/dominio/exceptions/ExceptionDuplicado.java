package com.venta_bolsas.ventas.dominio.exceptions;

public class ExceptionDuplicado extends RuntimeException{
    public ExceptionDuplicado(String message) {
        super(message);
    }
}
