package com.venta_bolsas.ventas.dominio.modelo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ProductoDto extends BaseId {

    private String nombre;
    private Double precioCosto;
    private Double piezas;
    private String color;
    private Double precioVenta;
    private Double precioRebaja;
    private String descripcion;
    private Integer stock;
    private String marca;
    private String contenido;
    private char habilitado;
    private int codigoBarrasId;

    private List<Integer> productoImagenesRelacionadas;


    public ProductoDto(Integer id) {
        super(id);
    }
}
