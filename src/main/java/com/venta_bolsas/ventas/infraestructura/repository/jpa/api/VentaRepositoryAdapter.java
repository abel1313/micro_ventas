package com.venta_bolsas.ventas.infraestructura.repository.jpa.api;

import com.venta_bolsas.ventas.aplicacion.out.VentaRepositoryJpaOut;
import com.venta_bolsas.ventas.dominio.exceptions.VentaNotFound;
import com.venta_bolsas.ventas.dominio.formaPago.DetallePago;
import com.venta_bolsas.ventas.dominio.formaPago.Venta;
import com.venta_bolsas.ventas.dominio.modelo.PageDto;
import com.venta_bolsas.ventas.infraestructura.mapper.VentaMapper;
import com.venta_bolsas.ventas.infraestructura.repository.jpa.IVentaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@AllArgsConstructor
@Slf4j
@Repository
public class VentaRepositoryAdapter implements VentaRepositoryJpaOut {

    private final IVentaRepository iVentaRepository;
    @Override
    public Venta saveOut(Venta venta, DetallePago detallePago) {
        return VentaMapper.ventaToDomain(this.iVentaRepository.save(VentaMapper.ventaToEntity(venta)), detallePago);
    }

    @Override
    public Venta updateOut(Venta venta, DetallePago detallePago) {
        return saveOut(venta, detallePago);
    }

    @Override
    public Venta findByIdUOut(Integer idVenta) {
        return VentaMapper.ventaToDomain(this.iVentaRepository.findById(idVenta).orElseThrow(()-> new VentaNotFound("La venta no existe")));
    }

    @Override
    public PageDto<Venta> findAllOut(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page-1, size);
        return VentaMapper.ventaEntityPageDomain(this.iVentaRepository.findAll(pageable));
    }

}
