package com.scanner20.bcpcuentasreactivemicroservice.controller;

import com.scanner20.bcpcuentasreactivemicroservice.model.Cuenta;
import com.scanner20.bcpcuentasreactivemicroservice.service.CuentaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/cuentas")
@RequiredArgsConstructor
public class CuentaController {

    private final CuentaService cuentaService;

    @GetMapping
    public Flux<Cuenta> listar() {
        return cuentaService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public Mono<Cuenta> obtenerPorId(@PathVariable Long id) {
        return cuentaService.obtenerPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Cuenta> crear(@RequestBody Cuenta cuenta) {
        return cuentaService.crear(cuenta);
    }
}
