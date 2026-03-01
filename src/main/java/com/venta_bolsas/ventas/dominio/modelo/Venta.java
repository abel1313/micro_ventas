package com.venta_bolsas.ventas.dominio.modelo;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class Venta  extends BaseId{


    private Double totalVenta;
    private String formaPago;
    private String estadoVenta;
    private Integer usuarioId;
    private LocalDateTime fechaVenta;
    private int pagosMesesInteres;
    private Integer pedidoId;
    private List<Integer> detallesIds;

    public Venta(Integer id, Double totalVenta, String formaPago, String estadoVenta,
                 Integer usuarioId, LocalDateTime fechaVenta, int pagosMesesInteres,
                 Integer pedidoId, List<Integer> detallesIds) {
        super(id);
        if (totalVenta <= 0) throw new IllegalArgumentException("El total debe ser mayor a 0");
        this.totalVenta = totalVenta;
        this.formaPago = formaPago;
        this.estadoVenta = estadoVenta;
        this.usuarioId = usuarioId;
        this.fechaVenta = fechaVenta;
        this.pagosMesesInteres = pagosMesesInteres;
        this.pedidoId = pedidoId;
        this.detallesIds = detallesIds;
    }

    public Venta() {
        super(0);

    }
}
