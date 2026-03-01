package com.venta_bolsas.ventas.infraestructura.salida;

import com.venta_bolsas.ventas.adaptador.entrada.dto.DetalleVentaDto;
import com.venta_bolsas.ventas.dominio.modelo.DetalleVentaModel;
import com.venta_bolsas.ventas.dominio.modelo.Venta;
import com.venta_bolsas.ventas.dominio.puerto.salida.DetalleServicePortExterno;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ConsumoDetalleVentaExternoAdapter implements DetalleServicePortExterno {

    @Value("${api.venta-detalle-ventas}")
    private String endpointDetalleVentas;

    private final WebClient webClient;

    public ConsumoDetalleVentaExternoAdapter(WebClient.Builder builder) {
        this.webClient = builder.baseUrl(endpointDetalleVentas).build();
    }

    @Override
    public List<DetalleVentaModel> saveDetalleVenta(List<DetalleVentaModel> detalleVentaDto) {
        return webClient.post()
                .uri("/detalle-ventas/save")
                .body(Mono.just(detalleVentaDto), new ParameterizedTypeReference<List<DetalleVentaModel>>() {})
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<DetalleVentaModel>>() {})
                .block();
    }
}
