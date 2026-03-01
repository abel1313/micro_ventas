package com.venta_bolsas.ventas.infraestructura.repository.jpa;

import com.venta_bolsas.ventas.infraestructura.repository.jpa.entity.ProductoEntoty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProdutoRepository extends JpaRepository<ProductoEntoty,Integer> {
    Page<ProductoEntoty> findByNombreContainingAndHabilitado(String nombre, char habilitadot, Pageable pageable); // 🔍 Busca por nombre
    Page<ProductoEntoty> findByCodigoBarras_CodigoBarrasContainingAndHabilitado(String codigoBarras, char habilitadot, Pageable pageable); // 🔍 Busca por código de barras
    Optional<ProductoEntoty> findByCodigoBarras_CodigoBarrasAndNombre(String codigoBarras, String nombre); // 🔍 Busca por código de barras
    Optional<ProductoEntoty> findByCodigoBarras_CodigoBarras(String codigoBarras); // 🔍 Busca por código de barras
    Page<ProductoEntoty> findByStockGreaterThanAndHabilitado(int stock, char habilitadot, Pageable pageable);


}
