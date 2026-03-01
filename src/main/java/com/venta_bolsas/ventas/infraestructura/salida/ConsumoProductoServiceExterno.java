package com.venta_bolsas.ventas.infraestructura.salida;

import com.venta_bolsas.ventas.dominio.modelo.ProductoDto;
import com.venta_bolsas.ventas.dominio.puerto.salida.ProductoServicePortExterno;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ConsumoProductoServiceExterno implements ProductoServicePortExterno {
    @Value("${api.productos}")
    private @NotNull String endpointProductos;

    private final WebClient webClient;

    public ConsumoProductoServiceExterno(WebClient.Builder builder) {
        this.webClient = builder.baseUrl(endpointProductos).build();
    }
    @Override
    public ProductoDto saveProducto(ProductoDto producto) {
        return webClient.post()
                .uri("/productos/save")
                .body(Mono.just(producto), ProductoDto.class)
                .retrieve()
                .bodyToMono(ProductoDto.class)
                .block();
    }

    @Override
    public ProductoDto findCodigoBarrasAndNombre(String codigoBarras, String nombre) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/ventas/{codigoBarras}/{nombre}")   // 🔹 Path con variable
                        .build(codigoBarras, nombre))             // 🔹 Se reemplaza {id} con el valor
                .retrieve()
                .bodyToMono(ProductoDto.class) // 🔹 Convierte la respuesta a tu DTO
                .block();
    }
}
