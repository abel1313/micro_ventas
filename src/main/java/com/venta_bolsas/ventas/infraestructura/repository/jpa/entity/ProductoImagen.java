package com.venta_bolsas.ventas.infraestructura.repository.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "producto_imagenes")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductoImagen extends BaseEntityId{

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private ProductoEntoty producto;

    @ManyToOne
    @JoinColumn(name = "imagen_id")
    private ImagenEntity imagen;

}
