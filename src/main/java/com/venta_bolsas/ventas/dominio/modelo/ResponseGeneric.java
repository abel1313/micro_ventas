package com.venta_bolsas.ventas.dominio.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;
@Getter
@ToString
@AllArgsConstructor
public class ResponseGeneric <T>{
    private long codigo;
    private String mensaje;
    private T response;

    public ResponseGeneric() {
        this.codigo = HttpStatus.BAD_REQUEST.value();
        this.mensaje = "Ocurrio un error al realizar la peticion";
    }
    public ResponseGeneric(T response) {
        if (response != null) {
            this.codigo = HttpStatus.OK.value();
            this.mensaje = "La peticion fue exitosa";
            this.response = response;
        }
    }
}
