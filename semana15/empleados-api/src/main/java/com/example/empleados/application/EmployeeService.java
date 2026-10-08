package com.example.empleados.application;

import com.example.empleados.domain.model.Employee;
import com.example.empleados.domain.model.Salary;
import com.example.empleados.domain.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public EmployeeResponse create(EmployeeRequest req) {
        Employee employee = new Employee(
                null,
                req.getNombre(),
                req.getEmail(),
                new Salary(req.getSalario()),
                req.getDepartamento()
        );
        return toResponse(repository.save(employee));
    }

    public EmployeeResponse findById(Long id) {
        Employee employee = repository.findById(id);
        if (employee == null) throw new EmployeeNotFoundException(id);
        return toResponse(employee);
    }

    public List<EmployeeResponse> findAll() {
        return repository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    private EmployeeResponse toResponse(Employee e) {
        return new EmployeeResponse(
                e.getId(),
                e.getNombre(),
                e.getEmail(),
                e.getSalary().getAmount(),
                e.getDepartamento()
        );
    }
}
