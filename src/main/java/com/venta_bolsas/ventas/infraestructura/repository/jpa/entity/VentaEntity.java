package com.venta_bolsas.ventas.infraestructura.repository.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
@Entity
@Table(name = "ventas")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VentaEntity extends BaseEntityId {

    @Column(name = "usuario_id")
    private Integer usuarioId;

    @Column(name = "total_venta", nullable = false)
    private Double totalVenta;

    @Column(name = "forma_pago", nullable = false)
    private String formaPago;

    @Column(name = "estado_venta", nullable = false)
    private String estadoVenta;

    @Column(name = "pagos_y_meses_id")
    private int pagosMesesInteres;


}
