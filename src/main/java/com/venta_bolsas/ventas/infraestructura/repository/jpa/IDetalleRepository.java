package com.venta_bolsas.ventas.infraestructura.repository.jpa;

import com.venta_bolsas.ventas.infraestructura.repository.jpa.entity.DetalleVentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDetalleRepository extends JpaRepository<DetalleVentaEntity, Integer> {
}
