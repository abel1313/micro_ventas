package com.venta_bolsas.ventas.adaptador.entrada.rest;

import com.venta_bolsas.ventas.adaptador.entrada.dto.DetalleVentaDto;
import com.venta_bolsas.ventas.adaptador.entrada.dto.TotalDetalle;
import com.venta_bolsas.ventas.dominio.modelo.Venta;
import com.venta_bolsas.ventas.dominio.puerto.entrada.GuardarVentaPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VentasController {
    private final GuardarVentaPort guardarVentaPort;

    public VentasController(GuardarVentaPort guardarVentaPort) {
        this.guardarVentaPort = guardarVentaPort;
    }

    @PostMapping
    public ResponseEntity<Void> crearVenta(@RequestBody Venta dto) {
        guardarVentaPort.guardarVenta(dto);
        return ResponseEntity.ok().build();
    }


    @PostMapping("/save")
    public ResponseEntity<Venta> save(@RequestBody List<DetalleVentaDto> lista ) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(this.guardarVentaPort.saveVentaDetalle(lista) );
    }
    @PostMapping("/getVentas")
    public ResponseEntity<List<Venta>> getVentas(@RequestParam int size,
                                                 @RequestParam int page,
                                                 @RequestParam String nombre ) throws Exception{
        //return ResponseEntity.status(HttpStatus.OK).body(this.guardarVentaPort.findAll(page,size) );

        return null;
    }
    @GetMapping("/getTotalVentas")
    public ResponseEntity<List<TotalDetalle>> getTotalVentas() throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(this.guardarVentaPort.getTotalDetalle() );
    }

}
