package com.venta_bolsas.ventas.infraestructura.repository.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tipo_pago")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TipoPago extends BaseEntityId{

    @Column(name = "forma_pago")
    private String formaPago;
}
