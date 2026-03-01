package com.venta_bolsas.ventas.dominio.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class DetalleVentaModel extends BaseId {


    private int ventaId;

    private int productoId;

    private Integer cantidad;

    private Double precioUnitario;

    private Double subTotal;

    private LocalDate fechaVenta;


    public DetalleVentaModel() {
        super(0);
    }
    public DetalleVentaModel(Integer id) {
        super(id);
    }

    @Override
    public String toString() {
        return "DetalleVentaModel{" +
                "ventaId=" + ventaId +
                ", productoId=" + productoId +
                ", cantidad=" + cantidad +
                ", precioUnitario=" + precioUnitario +
                ", subTotal=" + subTotal +
                ", fechaVenta=" + fechaVenta +
                '}';
    }
}
