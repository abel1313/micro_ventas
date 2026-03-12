package com.venta_bolsas.ventas.infraestructura.rest;

import com.venta_bolsas.ventas.aplicacion.in.VentaUserCase;
import com.venta_bolsas.ventas.dominio.exceptions.UsuarioNotFound;
import com.venta_bolsas.ventas.dominio.formaPago.Venta;
import com.venta_bolsas.ventas.dominio.modelo.PageDto;
import com.venta_bolsas.ventas.dominio.modelo.ResponseGeneric;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.concurrent.DelegatingSecurityContextCallable;
import org.springframework.security.concurrent.DelegatingSecurityContextExecutorService;
import org.springframework.security.concurrent.DelegatingSecurityContextRunnable;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.*;
import java.util.function.Supplier;

@RestController
@RequestMapping("/ventas")
@RequiredArgsConstructor
@Slf4j
public class VentasController extends ResponseEntityGeneric<Venta> {
//    private final GuardarVentaPort guardarVentaPort;
    private final VentaUserCase ventaUserCase;
    private final Executor taskExecutor;

    @Value("${api.codigo_barras}")
    private String barras;
    @Value("${api.venta-service}")
    private String ventas;
    @Value("${api.venta-detalle-ventas}")
    private String detalle;
    @Value("${api.productos}")
    private String productos;


    @PostConstruct
    public void init(){
        log.info("barras {}",barras);
        log.info("ventas {}",ventas);
        log.info("detalle {}",detalle);
        log.info("productos {}",productos);
    }
    @Operation(
            summary = "Obtiene las ventas",
            description = "Devuelve las ventas paginadas",
            security = { @SecurityRequirement(name = "bearerAuth") }
    )
    @ApiResponse(responseCode = "200", description = "Ventas encontradas")
    @ApiResponse(responseCode = "404", description = "Ventas no encontradas")
    @GetMapping
    public ResponseEntity<ResponseGeneric<PageDto<Venta>>> obtenerVentas(
            @Parameter(description = "pagina a buscar", required = true) @RequestParam Integer page,
            @Parameter(description = "tamano a regresar", required = true) @RequestParam Integer size) {
        return responseEntity(this.ventaUserCase.findAllUserCase(page, size));
    }

    @Operation(
            summary = "Obtener venta por ID",
            description = "Devuelve una venta específica",
            security = { @SecurityRequirement(name = "bearerAuth") }
    )
    @ApiResponse(responseCode = "200", description = "Venta encontrada")
    @ApiResponse(responseCode = "404", description = "Venta no encontrada")
    @GetMapping("/{idVenta}")
    public ResponseEntity<ResponseGeneric<Venta>> obtenerVentaId(
            @Parameter(description = "ID de la venta",example = "1", required = true) @PathVariable Integer idVenta) {
        return responseEntity(this.ventaUserCase.findByIdUseCase(idVenta));
    }

    @Operation(
            summary = "Generar una venta",
            description = "Da de alta una nueva venta",
            security = { @SecurityRequirement(name = "bearerAuth") }
    )
    @ApiResponse(responseCode = "200", description = "Venta creada")
    @ApiResponse(responseCode = "404", description = "Error al crear la venta")
    @PostMapping
    public ResponseEntity<com.venta_bolsas.ventas.dominio.formaPago.Venta> crearVenta(@RequestBody com.venta_bolsas.ventas.dominio.formaPago.Venta dto) {
        return ResponseEntity.status(HttpStatus.OK).body(ventaUserCase.saveUseCase(dto));
    }
    @Operation(
            summary = "Actualizar una venta",
            description = "Actualizar una venta",
            security = { @SecurityRequirement(name = "bearerAuth") }
    )
    @ApiResponse(responseCode = "200", description = "Venta actualizada")
    @ApiResponse(responseCode = "404", description = "Error al actualizar la venta")
    @PutMapping
    public ResponseEntity<ResponseGeneric<Venta>> actualizarVenta(@RequestBody Venta venta) {
        return responseEntity(this.ventaUserCase.updateUseCase(venta));
    }


    //    @PostMapping("/save")
//    public ResponseEntity<Venta> save(@RequestBody List<DetalleVentaDto> lista ) throws Exception{
//        return ResponseEntity.status(HttpStatus.OK).body(this.guardarVentaPort.saveVentaDetalle(lista) );
//    }
    @PostMapping("/getVentas")
    public ResponseEntity<List<Venta>> getVentas(@RequestParam int size,
                                                 @RequestParam int page,
                                                 @RequestParam String nombre ) throws Exception{
        //return ResponseEntity.status(HttpStatus.OK).body(this.guardarVentaPort.findAll(page,size) );

        return null;
    }
//    @GetMapping("/getTotalVentas")
//    public ResponseEntity<List<TotalDetalle>> getTotalVentas() throws Exception{
//        return ResponseEntity.status(HttpStatus.OK).body(this.guardarVentaPort.getTotalDetalle() );
//    }


}
