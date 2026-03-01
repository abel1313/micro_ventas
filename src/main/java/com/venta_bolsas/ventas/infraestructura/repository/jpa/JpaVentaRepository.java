package com.venta_bolsas.ventas.infraestructura.repository.jpa;

import com.venta_bolsas.ventas.infraestructura.repository.jpa.entity.VentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaVentaRepository extends JpaRepository<VentaEntity, Integer> {
}
