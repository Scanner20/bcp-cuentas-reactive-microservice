package com.scanner20.bcpcuentasreactivemicroservice.repository;

import com.scanner20.bcpcuentasreactivemicroservice.model.Cuenta;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface CuentaRepository extends R2dbcRepository<Cuenta, Long> {
    Mono<Cuenta> findByNumeroCuenta(String numeroCuenta);
}
