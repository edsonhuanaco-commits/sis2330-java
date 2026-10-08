package com.example.empleados.application;

import java.math.BigDecimal;

public class EmployeeResponse {
    private Long id;
    private String nombre;
    private String email;
    private BigDecimal salario;
    private String departamento;

    public EmployeeResponse(Long id, String nombre, String email,
                            BigDecimal salario, String departamento) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.salario = salario;
        this.departamento = departamento;
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public BigDecimal getSalario() { return salario; }
    public String getDepartamento() { return departamento; }
}
