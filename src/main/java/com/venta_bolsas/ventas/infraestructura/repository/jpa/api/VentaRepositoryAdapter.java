package com.venta_bolsas.ventas.infraestructura.repository.jpa.api;

import com.venta_bolsas.ventas.aplicacion.out.VentaRepositoryJpaOut;
import com.venta_bolsas.ventas.dominio.formaPago.DetallePago;
import com.venta_bolsas.ventas.dominio.formaPago.Venta;
import com.venta_bolsas.ventas.infraestructura.mapper.VentaMapper;
import com.venta_bolsas.ventas.infraestructura.repository.jpa.IVentaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Slf4j
@Repository
public class VentaRepositoryAdapter implements VentaRepositoryJpaOut {

    private final IVentaRepository iVentaRepository;
    @Override
    public Venta saveUseCaseRepo(Venta venta, DetallePago detallePago) {
        return VentaMapper.ventaToDomain(this.iVentaRepository.save(VentaMapper.ventaToEntity(venta)), detallePago);
    }
}
