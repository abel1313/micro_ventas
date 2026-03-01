package com.venta_bolsas.ventas.infraestructura.config;

import com.venta_bolsas.ventas.dominio.puerto.salida.DetalleServicePortExterno;
import com.venta_bolsas.ventas.dominio.puerto.salida.GuardarVentaRepositorioPort;
import com.venta_bolsas.ventas.dominio.puerto.salida.ProductoServicePortExterno;
import com.venta_bolsas.ventas.dominio.puerto.salida.VentaServicePortExterno;
import com.venta_bolsas.ventas.dominio.servicio.GuardarVentaService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

/**
 *     @Bean
 *     public GuardarVentaService guardarVentaService(GuardarVentaRepositorioPort repo,
 *                                                    VentaServicePortExterno ventaServicePortExterno,
 *                                                    DetalleServicePortExterno detalleServicePortExterno,
 *                                                    ProductoServicePortExterno productoServicePortExterno) {
 *         return new GuardarVentaService(repo,ventaServicePortExterno, detalleServicePortExterno, productoServicePortExterno);
 *     }
 * */
}
