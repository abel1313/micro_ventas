package com.venta_bolsas.ventas.infraestructura.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
@Getter
@Setter
public class SourceDB {

    private String url;
    private String username;
    private String password;
}
