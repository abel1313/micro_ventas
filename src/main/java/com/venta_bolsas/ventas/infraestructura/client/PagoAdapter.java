package com.venta_bolsas.ventas.infraestructura.client;

import com.venta_bolsas.ventas.aplicacion.out.PagosPortOut;
import com.venta_bolsas.ventas.dominio.formaPago.DetallePago;
import com.venta_bolsas.ventas.dominio.modelo.ResponseGeneric;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Component
@Slf4j
public class PagoAdapter implements PagosPortOut {

    private WebClient webClient;

    @Value("${pagos-url.pagos}")
    private String pagosUrl;

    private WebClient.Builder builder;
    public PagoAdapter(WebClient.Builder builder,
                       @Value("${pagos-url.pagos}") String pagosUrl) {
        this.webClient = builder.baseUrl(pagosUrl).build();
    }
    @Override
    public Mono<ResponseGeneric<Optional<DetallePago>>> obtenerDetallePago(Integer tipoPago, Integer tarifaTerminalId, Integer ivaId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String jwt = (String) authentication.getDetails();
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/tipo-pagos")
                        .queryParam("tipoPago", tipoPago)
                        .queryParam("tarifaTerminalId", tarifaTerminalId)
                        .queryParam("ivaId", ivaId)
                        .build())
                .header("Authorization", "Bearer ".concat(jwt))
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {});
    }
}
