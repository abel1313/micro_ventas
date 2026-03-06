package com.venta_bolsas.ventas.dominio.formaPago;

import com.venta_bolsas.ventas.dominio.modelo.Usuario;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Venta {

    private Usuario usuario;
    private Double totalVenta;
    private DetallePago detallePago;
    private String estadoVenta;
}
