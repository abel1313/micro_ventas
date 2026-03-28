package com.venta_bolsas.ventas.infraestructura.config;

import com.venta_bolsas.ventas.infraestructura.config.properties.ConfigToken;
import com.venta_bolsas.ventas.infraestructura.config.properties.SourceDB;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AppProperties {

    private final SourceDB sourceDB;
    private final ConfigToken configToken;

}
