package com.venta_bolsas.ventas.infraestructura.repository.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "imagenes")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ImagenEntity extends BaseEntityId{

    @Lob
    @Column(name = "base_64", columnDefinition = "BLOB")
    private byte[] base64;

    private String extension;

    @Column(name = "nombre_imagen")
    private String nombreImagen;

    @OneToMany(mappedBy = "imagen", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductoImagen> listProductoImanen;

    public ImagenEntity(byte[] base64, String extension, String nombreImagen) {
        this.base64 = base64;
        this.extension = extension;
        this.nombreImagen = nombreImagen;

    }
}
