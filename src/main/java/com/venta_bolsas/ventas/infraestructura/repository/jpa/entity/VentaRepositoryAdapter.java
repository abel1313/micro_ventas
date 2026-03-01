package com.venta_bolsas.ventas.infraestructura.repository.jpa.entity;

import com.venta_bolsas.ventas.adaptador.entrada.dto.DetalleVentaDto;
import com.venta_bolsas.ventas.adaptador.entrada.dto.TotalDetalle;
import com.venta_bolsas.ventas.dominio.modelo.Venta;
import com.venta_bolsas.ventas.dominio.puerto.salida.GuardarVentaRepositorioPort;
import com.venta_bolsas.ventas.infraestructura.repository.jpa.IDetalleRepository;
import com.venta_bolsas.ventas.infraestructura.repository.jpa.IProdutoRepository;
import com.venta_bolsas.ventas.infraestructura.repository.jpa.JpaVentaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class VentaRepositoryAdapter implements GuardarVentaRepositorioPort {
    @PersistenceContext
    private EntityManager entityManager;
    private final JpaVentaRepository jpaVentaRepository;
    private final IProdutoRepository iPrductoRepository;
    private final IDetalleRepository iDetalleRepository;
    public VentaRepositoryAdapter(JpaVentaRepository jpaVentaRepository,
                                  final IProdutoRepository iPrductoRepository,
                                  final IDetalleRepository iDetalleRepository) {
        this.jpaVentaRepository = jpaVentaRepository;
        this.iPrductoRepository = iPrductoRepository;
        this.iDetalleRepository = iDetalleRepository;
    }
    @Override
    public void guardar(Venta venta) {
        jpaVentaRepository.save(new VentaEntity());
    }

    @Override
    public Venta saveVentaDetallePortRepo(List<DetalleVentaDto> detall) {
        Double tot = detall.stream().mapToDouble(DetalleVentaDto::getSubTotal).sum();
        VentaEntity venta = new VentaEntity();
        //venta.setUsuarioId(1);
        venta.setEstadoVenta("null");
        venta.setFormaPago("null");
        venta.setTotalVenta(tot);

        VentaEntity ve = this.jpaVentaRepository.save(venta);

        List<DetalleVentaEntity> detalleVentaEntity = detall.stream().map(m->{
            DetalleVentaEntity det = new DetalleVentaEntity();
            det.setCantidad(m.getCantidad());
            det.setPrecioUnitario(m.getPrecioVenta());
            ProductoEntoty pro;
            pro = this.iPrductoRepository.findByCodigoBarras_CodigoBarrasAndNombre(m.getCodigoBarras(),m.getNombre()).orElse(new ProductoEntoty());
            det.setVenta(ve);
            det.setProducto(pro);
            det.setSubTotal(m.getSubTotal());
            return det;
        }).collect(Collectors.toList());

        try {
            List<DetalleVentaEntity> dtVenta = this.iDetalleRepository.saveAll(detalleVentaEntity);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return new Venta();
    }
    @Transactional
    @SuppressWarnings("unchecked")
    @Override
    public List<TotalDetalle> getTotalDetallePortRepo() {
        return  entityManager.createNativeQuery("CALL inventario_key.TOTAL_DETALLE()", TotalDetalle.class)
                .getResultList();
    }
}
