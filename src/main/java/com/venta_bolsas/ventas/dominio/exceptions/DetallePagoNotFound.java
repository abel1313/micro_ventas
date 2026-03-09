package com.venta_bolsas.ventas.dominio.exceptions;

public class DetallePagoNotFound extends RuntimeException{
    public DetallePagoNotFound(String message) {
        super(message);
    }
}
