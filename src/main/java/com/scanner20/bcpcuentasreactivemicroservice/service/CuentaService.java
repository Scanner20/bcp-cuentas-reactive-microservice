package com.scanner20.bcpcuentasreactivemicroservice.service;

import com.scanner20.bcpcuentasreactivemicroservice.exception.CuentaNotFoundException;
import com.scanner20.bcpcuentasreactivemicroservice.model.Cuenta;
import com.scanner20.bcpcuentasreactivemicroservice.repository.CuentaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CuentaService {

    private final CuentaRepository cuentaRepository;

    public Flux<Cuenta> obtenerTodas() {
        return cuentaRepository.findAll();
    }

    public Mono<Cuenta> obtenerPorId(Long id) {
        return cuentaRepository.findById(id)
                .switchIfEmpty(Mono.error(new CuentaNotFoundException(id)));
    }

    public Mono<Cuenta> crear(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }
}
