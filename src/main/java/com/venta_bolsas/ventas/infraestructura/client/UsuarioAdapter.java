package com.venta_bolsas.ventas.infraestructura.client;

import com.venta_bolsas.ventas.aplicacion.out.UsuarioPortOut;
import com.venta_bolsas.ventas.dominio.modelo.ResponseGeneric;
import com.venta_bolsas.ventas.dominio.modelo.Usuario;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Component
@Slf4j
public class UsuarioAdapter implements UsuarioPortOut {

    private WebClient webClient;

    @Value("${api.usuarios}")
    private String usuariosUrl;

    private WebClient.Builder builder;
    public UsuarioAdapter(WebClient.Builder builder,
                       @Value("${api.usuarios}") String usuariosUrl) {
        this.webClient = builder.baseUrl(usuariosUrl).build();
    }

    @Override
    public Optional<Usuario> findById(Integer id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String jwt = (String) authentication.getDetails();
        return Optional.ofNullable(webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/".concat(String.valueOf(id)))
                        .build())
                .header(HttpHeaders.AUTHORIZATION, "Bearer ".concat(jwt))
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<ResponseGeneric<Usuario>>() {
                }).map(ResponseGeneric::getResponse).block());
    }
}
