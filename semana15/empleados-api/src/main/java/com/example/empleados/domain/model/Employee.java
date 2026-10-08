package com.example.empleados.domain.model;

public class Employee {
    private Long id;
    private String nombre;
    private String email;
    private Salary salary;
    private String departamento;

    public Employee(Long id, String nombre, String email, Salary salary, String departamento) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.salary = salary;
        this.departamento = departamento;
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public Salary getSalary() { return salary; }
    public String getDepartamento() { return departamento; }
}
