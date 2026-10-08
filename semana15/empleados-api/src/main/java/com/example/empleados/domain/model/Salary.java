package com.example.empleados.domain.model;

import java.math.BigDecimal;

public final class Salary {
    private final BigDecimal amount;

    public Salary(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Salary cannot be negative");
        }
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
