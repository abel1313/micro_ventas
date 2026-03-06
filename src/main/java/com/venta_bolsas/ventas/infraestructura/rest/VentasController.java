package com.venta_bolsas.ventas.infraestructura.rest;

import com.venta_bolsas.ventas.aplicacion.entrada.dto.DetalleVentaDto;
import com.venta_bolsas.ventas.aplicacion.entrada.dto.TotalDetalle;
import com.venta_bolsas.ventas.aplicacion.in.VentaUserCase;
import com.venta_bolsas.ventas.dominio.modelo.Venta;
import com.venta_bolsas.ventas.dominio.puerto.entrada.GuardarVentaPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("venta")
@AllArgsConstructor
@Slf4j
public class VentasController {
//    private final GuardarVentaPort guardarVentaPort;
    private final VentaUserCase ventaUserCase;


    @PostMapping
    public ResponseEntity<com.venta_bolsas.ventas.dominio.formaPago.Venta> crearVenta(@RequestBody com.venta_bolsas.ventas.dominio.formaPago.Venta dto) {

        return ResponseEntity.status(HttpStatus.OK).body(ventaUserCase.saveUseCase(dto));
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
