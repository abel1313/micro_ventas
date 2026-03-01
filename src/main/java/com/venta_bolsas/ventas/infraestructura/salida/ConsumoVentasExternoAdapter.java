package com.venta_bolsas.ventas.infraestructura.salida;

import com.venta_bolsas.ventas.dominio.modelo.Venta;
import com.venta_bolsas.ventas.dominio.puerto.salida.VentaServicePortExterno;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ConsumoVentasExternoAdapter implements VentaServicePortExterno {

    @Value("${api.venta-service}")
    private String endpointVentas;

    private final WebClient webClient;

    public ConsumoVentasExternoAdapter(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("endpointVentas").build();
    }

    @Override
    public Venta saveVenta(Venta venta) {
        return webClient.post()
                .uri("/ventas/save")
                .body(Mono.just(venta), Venta.class)
                .retrieve()
                .bodyToMono(Venta.class)
                .block();
    }
}
