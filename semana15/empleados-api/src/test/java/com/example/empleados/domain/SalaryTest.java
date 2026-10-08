package com.example.empleados.domain;

import com.example.empleados.domain.model.Salary;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class SalaryTest {

    @Test
    void salaryCannotBeNegative() {
        assertThrows(IllegalArgumentException.class,
                () -> new Salary(new BigDecimal("-100")));
    }

    @Test
    void salaryStoresCorrectValue() {
        Salary s = new Salary(new BigDecimal("5000"));
        assertEquals(new BigDecimal("5000"), s.getAmount());
    }
}
