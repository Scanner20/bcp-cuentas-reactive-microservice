package com.scanner20.bcpcuentasreactivemicroservice;

import com.scanner20.bcpcuentasreactivemicroservice.model.Cuenta;
import com.scanner20.bcpcuentasreactivemicroservice.repository.CuentaRepository;
import com.scanner20.bcpcuentasreactivemicroservice.service.CuentaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.math.BigDecimal;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CuentaServiceTest {

    @Mock
    private CuentaRepository cuentaRepository;

    @InjectMocks
    private CuentaService cuentaService;

    @Test
    void obtenerPorId_deberiaRetornarCuenta_cuandoExiste() {
        Cuenta cuenta = new Cuenta(1L, "001-123", "Ana Torres", new BigDecimal("500.00"));
        when(cuentaRepository.findById(1L)).thenReturn(Mono.just(cuenta));

        StepVerifier.create(cuentaService.obtenerPorId(1L))
                .expectNextMatches(c -> c.getTitular().equals("Ana Torres"))
                .verifyComplete();
    }

    @Test
    void obtenerPorId_deberiaLanzarError_cuandoNoExiste() {
        when(cuentaRepository.findById(99L)).thenReturn(Mono.empty());

        StepVerifier.create(cuentaService.obtenerPorId(99L))
                .expectErrorMatches(err -> err.getMessage().contains("no encontrada"))
                .verify();
    }
}
