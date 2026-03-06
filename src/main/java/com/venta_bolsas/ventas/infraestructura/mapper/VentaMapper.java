package com.venta_bolsas.ventas.infraestructura.mapper;

import com.venta_bolsas.ventas.dominio.formaPago.*;
import com.venta_bolsas.ventas.dominio.modelo.Usuario;
import com.venta_bolsas.ventas.infraestructura.repository.jpa.entity.VentaEntity;

public class VentaMapper {

    public static VentaEntity ventaToEntity(Venta venta){
        VentaEntity ventaEntity = new VentaEntity();
        ventaEntity.setEstadoVenta(venta.getEstadoVenta());
        ventaEntity.setTotalVenta(venta.getTotalVenta());
        Usuario usuario = venta.getUsuario();
        ventaEntity.setUsuarioId(usuario.getId());
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
        Venta venta = new Venta();
        venta.setEstadoVenta(ventaEntity.getEstadoVenta());
        venta.setTotalVenta(ventaEntity.getTotalVenta());
        venta.setDetallePago(detallePago);
        return venta;
    }

}
