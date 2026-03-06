package com.venta_bolsas.ventas.infraestructura.repository.jpa;

import com.venta_bolsas.ventas.infraestructura.repository.jpa.entity.VentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVentaRepository extends JpaRepository<VentaEntity, Integer> {
}
