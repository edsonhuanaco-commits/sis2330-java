package com.example.empleados.application;

import com.example.empleados.domain.model.Employee;
import com.example.empleados.domain.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {

    @Test
    void createReturnsEmployeeResponse() {
        EmployeeRepository fakeRepo = new EmployeeRepository() {
            private Employee saved;
            @Override public Employee findById(Long id) { return saved; }
            @Override public List<Employee> findAll() { return List.of(saved); }
            @Override public Employee save(Employee e) {
                Employee withId = new Employee(1L, e.getNombre(), e.getEmail(),
                        e.getSalary(), e.getDepartamento());
                saved = withId;
                return withId;
            }
            @Override public void deleteById(Long id) {}
            @Override public boolean existsById(Long id) { return false; }
        };

        EmployeeService service = new EmployeeService(fakeRepo);

        EmployeeRequest req = new EmployeeRequest();
        req.setNombre("Ana");
        req.setEmail("ana@empresa.com");
        req.setSalario(new BigDecimal("5000"));
        req.setDepartamento("IT");

        EmployeeResponse response = service.create(req);

        assertEquals(1L, response.getId());
        assertEquals("Ana", response.getNombre());
        assertEquals("ana@empresa.com", response.getEmail());
        assertEquals(new BigDecimal("5000"), response.getSalario());
        assertEquals("IT", response.getDepartamento());
    }

    @Test
    void findByIdThrowsWhenNotFound() {
        EmployeeRepository emptyRepo = new EmployeeRepository() {
            @Override public Employee findById(Long id) { return null; }
            @Override public List<Employee> findAll() { return List.of(); }
            @Override public Employee save(Employee e) { return e; }
            @Override public void deleteById(Long id) {}
            @Override public boolean existsById(Long id) { return false; }
        };

        EmployeeService service = new EmployeeService(emptyRepo);

        assertThrows(EmployeeNotFoundException.class, () -> service.findById(99L));
    }
}
