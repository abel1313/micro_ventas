package com.venta_bolsas.ventas.dominio.formaPago;

import java.math.BigDecimal;

public interface ICalcularTarifaTerminal {

    BigDecimal calcularTarifa(BigDecimal tarifa);
}
