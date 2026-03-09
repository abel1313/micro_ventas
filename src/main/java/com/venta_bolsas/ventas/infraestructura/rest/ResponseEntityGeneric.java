package com.venta_bolsas.ventas.infraestructura.rest;

import com.venta_bolsas.ventas.dominio.modelo.PageDto;
import com.venta_bolsas.ventas.dominio.modelo.ResponseGeneric;
import org.hibernate.query.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class ResponseEntityGeneric <T>{


    Mono<ResponseEntity<ResponseGeneric<T>>> responseEntity(Mono<T> respuesta){
        return respuesta
                .map(res -> ResponseEntity.ok(new ResponseGeneric<>(res)))
                .defaultIfEmpty(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ResponseGeneric<>(404, "No se encontró el recurso", null)));
    }

    ResponseEntity<ResponseGeneric<T>> responseEntity(T respuesta){
        if(respuesta != null){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseGeneric<>(respuesta));
        }
        return ResponseEntity.ok(new ResponseGeneric<>());
    }

    ResponseEntity<Mono<ResponseGeneric<T>>> responseEntityA(T respuesta){
        if(respuesta != null){
            return ResponseEntity.status(HttpStatus.OK).body(Mono.just(new ResponseGeneric<>(respuesta)));
        }
        return ResponseEntity.ok(Mono.empty());
    }
    ResponseEntity<ResponseGeneric<Mono<T>>> responseEntityb(T respuesta){

        if(respuesta != null){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseGeneric<>(Mono.just(respuesta)));
        }
        return ResponseEntity.ok(new ResponseGeneric<>());
    }
    CompletableFuture<ResponseEntity<ResponseGeneric<T>>> responseEntityC(T respuesta){
        return CompletableFuture.supplyAsync(()-> ResponseEntity.ok(new ResponseGeneric<>(respuesta)));
    }

    ResponseEntity<ResponseGeneric<PageDto<T>>> responseEntity(PageDto<T> respuesta){
        if(respuesta != null){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseGeneric<>(respuesta));
        }
        return ResponseEntity.ok(new ResponseGeneric<>());
    }
}
