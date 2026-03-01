package com.venta_bolsas.ventas.infraestructura.repository.jpa.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class BaseEntityId {

    @Id // 📌 Indica que es la llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 📌 AutoIncrement en MySQL
    private Integer id;

}
