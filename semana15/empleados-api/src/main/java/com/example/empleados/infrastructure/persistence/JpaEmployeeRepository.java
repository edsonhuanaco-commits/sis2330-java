package com.example.empleados.infrastructure.persistence;

import com.example.empleados.domain.model.Employee;
import com.example.empleados.domain.model.Salary;
import com.example.empleados.domain.repository.EmployeeRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class JpaEmployeeRepository implements EmployeeRepository {

    private final SpringDataEmployeeRepo springRepo;

    public JpaEmployeeRepository(SpringDataEmployeeRepo springRepo) {
        this.springRepo = springRepo;
    }

    @Override
    public Employee findById(Long id) {
        return springRepo.findById(id).map(this::toDomain).orElse(null);
    }

    @Override
    public List<Employee> findAll() {
        return springRepo.findAll().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Employee save(Employee employee) {
        EmployeeJpaEntity entity = toJpa(employee);
        return toDomain(springRepo.save(entity));
    }

    @Override
    public void deleteById(Long id) {
        springRepo.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return springRepo.existsById(id);
    }

    private Employee toDomain(EmployeeJpaEntity e) {
        return new Employee(
                e.getId(),
                e.getNombre(),
                e.getEmail(),
                new Salary(e.getSalario()),
                e.getDepartamento()
        );
    }

    private EmployeeJpaEntity toJpa(Employee employee) {
        EmployeeJpaEntity e = new EmployeeJpaEntity();
        e.setId(employee.getId());
        e.setNombre(employee.getNombre());
        e.setEmail(employee.getEmail());
        e.setSalario(employee.getSalary().getAmount());
        e.setDepartamento(employee.getDepartamento());
        return e;
    }
}
