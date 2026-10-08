package com.example.empleados.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataEmployeeRepo extends JpaRepository<EmployeeJpaEntity, Long> {
}
