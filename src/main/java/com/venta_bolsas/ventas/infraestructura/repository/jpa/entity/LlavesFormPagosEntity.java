package com.venta_bolsas.ventas.infraestructura.repository.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class LlavesFormPagosEntity {

    @Column(name = "tipo_pago_id")
    private int tipoPago;
    @Column(name = "tarifa_terminal_id")
    private int tarifaTerminalId;
    @Column(name = "iva_id")
    private int ivaId;
}
