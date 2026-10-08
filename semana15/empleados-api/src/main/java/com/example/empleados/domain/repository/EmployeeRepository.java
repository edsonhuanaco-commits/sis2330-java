package com.example.empleados.domain.repository;

import com.example.empleados.domain.model.Employee;
import java.util.List;

public interface EmployeeRepository {
    Employee findById(Long id);
    List<Employee> findAll();
    Employee save(Employee employee);
    void deleteById(Long id);
    boolean existsById(Long id);
}
