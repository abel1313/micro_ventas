//package com.venta_bolsas.ventas.dominio.servicio;
//
//import com.venta_bolsas.ventas.aplicacion.entrada.dto.DetalleVentaDto;
//import com.venta_bolsas.ventas.aplicacion.entrada.dto.TotalDetalle;
//import com.venta_bolsas.ventas.dominio.modelo.DetalleVentaModel;
//import com.venta_bolsas.ventas.dominio.modelo.ProductoDto;
//import com.venta_bolsas.ventas.dominio.modelo.Venta;
//import com.venta_bolsas.ventas.dominio.puerto.entrada.GuardarVentaPort;
//import com.venta_bolsas.ventas.dominio.puerto.salida.DetalleServicePortExterno;
//import com.venta_bolsas.ventas.dominio.puerto.salida.GuardarVentaRepositorioPort;
//import com.venta_bolsas.ventas.dominio.puerto.salida.ProductoServicePortExterno;
//import com.venta_bolsas.ventas.dominio.puerto.salida.VentaServicePortExterno;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//
//@Service
//public class GuardarVentaService implements GuardarVentaPort {
//    private final GuardarVentaRepositorioPort guardarVentaRepositorioPort;
//    private final VentaServicePortExterno ventaServicePortExterno;
//    private final DetalleServicePortExterno detalleServicePortExterno;
//    private final ProductoServicePortExterno productoServicePortExterno;
//    public GuardarVentaService(GuardarVentaRepositorioPort guardarVentaRepositorioPort,
//                               VentaServicePortExterno ventaServicePortExterno,
//                               DetalleServicePortExterno detalleServicePortExterno,
//                               ProductoServicePortExterno productoServicePortExterno) {
//        this.guardarVentaRepositorioPort = guardarVentaRepositorioPort;
//        this.ventaServicePortExterno = ventaServicePortExterno;
//        this.detalleServicePortExterno = detalleServicePortExterno;
//        this.productoServicePortExterno = productoServicePortExterno;
//    }
//    @Override
//    public void guardarVenta(Venta venta) {
//        // Reglas de negocio: validaciones antes de guardar
//        if (venta.getTotalVenta() == null || venta.getTotalVenta() <= 0) {
//            throw new IllegalArgumentException("El total de la venta debe ser mayor a 0");
//        }
//        // Usa el puerto de salida para persistir
//        guardarVentaRepositorioPort.guardar(venta);
//    }
//
//
//    @Transactional
//    public Venta saveVentaDetalle(List<DetalleVentaDto> detall){
//
//
//        Double tot = detall.stream().mapToDouble(DetalleVentaDto::getSubTotal).sum();
//        Venta venta = new Venta();
//        //venta.setUsuarioId(1);
//        venta.setEstadoVenta("null");
//        venta.setFormaPago("null");
//        venta.setTotalVenta(tot);
//
//        Venta ve = this.ventaServicePortExterno.saveVenta(venta);
//
//        List<DetalleVentaModel> detalleVenta = detall.stream().map(m->{
//            DetalleVentaModel det = new DetalleVentaModel();
//            det.setCantidad(m.getCantidad());
//            det.setPrecioUnitario(m.getPrecioVenta());
//            ProductoDto pro;
//            pro = this.productoServicePortExterno.findCodigoBarrasAndNombre(m.getCodigoBarras(),m.getNombre());
//            det.setVentaId(ve.getId());
//            det.setProductoId(pro.getId());
//            det.setSubTotal(m.getSubTotal());
//            return det;
//        }).collect(Collectors.toList());
//
//        try {
//            List<DetalleVentaModel> dtVenta = this.detalleServicePortExterno.saveDetalleVenta(detalleVenta);
//        } catch (Exception e) {
//            // TODO: handle exception
//        }
//        return ve;
//
//    }
//
//    @Override
//    public List<TotalDetalle> getTotalDetalle() {
//        return List.of();
//    }
//}
