package com.venta_bolsas.ventas.infraestructura.mapper;

import com.venta_bolsas.ventas.dominio.formaPago.*;
import com.venta_bolsas.ventas.dominio.modelo.PageDto;
import com.venta_bolsas.ventas.dominio.modelo.Usuario;
import com.venta_bolsas.ventas.infraestructura.repository.jpa.entity.VentaEntity;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public class VentaMapper {

    public static VentaEntity ventaToEntity(Venta venta){
        VentaEntity ventaEntity = new VentaEntity();
        ventaEntity.setId(venta.getId());
        ventaEntity.setEstadoVenta(venta.getEstadoVenta());
        ventaEntity.setTotalVenta(venta.getTotalVenta());
        Usuario usuario = venta.getUsuario();
        ventaEntity.setUsuarioId(usuario.getIdUsuario());
        DetallePago detallePago = venta.getDetallePago();
        TipoPago tipoPago = detallePago.getTipoPago();
        TarifaTerminal tarifaTerminal = detallePago.getTarifaTerminal();
        IvaTerminal ivaTerminal = detallePago.getIvaTerminal();
        ventaEntity.setIvaId(ivaTerminal.getId());
        ventaEntity.setTipoPagoId(tipoPago.getId());
        ventaEntity.setTarifaTerminalId(tarifaTerminal.getId());
        return ventaEntity;
    }

    public static Venta ventaToDomain(VentaEntity ventaEntity, DetallePago detallePago){
        Venta venta = ventaToDomain(ventaEntity);
        venta.setEstadoVenta(ventaEntity.getEstadoVenta());
        venta.setTotalVenta(ventaEntity.getTotalVenta());
        venta.setDetallePago(detallePago);
        return venta;
    }
    public static Venta ventaToDomain(VentaEntity ventaEntity){
        Venta venta = new Venta();
        venta.setId(ventaEntity.getId());
        venta.setEstadoVenta(ventaEntity.getEstadoVenta());
        venta.setTotalVenta(ventaEntity.getTotalVenta());
        venta.setUsuario(Usuario.builder().idUsuario(ventaEntity.getUsuarioId()).build());
        TipoPago tipoPago = new TipoPago();
        tipoPago.setId(ventaEntity.getTipoPagoId());
        DetallePago detallePago = new DetallePago();
        TarifaTerminal tarifaTerminal = new TarifaTerminal();
        tarifaTerminal.setId(ventaEntity.getTarifaTerminalId());
        IvaTerminal ivaTerminal = new IvaTerminal();
        ivaTerminal.setId(ventaEntity.getIvaId());
        detallePago.setTipoPago(tipoPago);
        detallePago.setTarifaTerminal(tarifaTerminal);
        detallePago.setIvaTerminal(ivaTerminal);
        venta.setDetallePago(detallePago);
        return venta;
    }


    public static PageDto<Venta> ventaEntityPageDomain(Page<VentaEntity> page){
        PageDto<Venta> pageDto = new PageDto<>();
        List<Venta> ventas = page.getContent().stream().map(VentaMapper::ventaToDomain).toList();
        pageDto.setContenido(ventas);
        pageDto.setSize(page.getSize());
        pageDto.setPage(page.getNumber()+1);
        pageDto.setTotalElementos(page.getNumberOfElements());
        return pageDto;
    }

}
