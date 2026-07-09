package com.scanner20.bcpcuentasreactivemicroservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Table("cuentas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cuenta {
    @Id
    private Long id;
    private String numeroCuenta;
    private String titular;
    private BigDecimal saldo;
}