package com.venta_bolsas.ventas.infraestructura.repository.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "iva_terminal")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TarifaTerminal extends BaseEntityId{


    private Double tarifa;
    private String descripcion;

}
