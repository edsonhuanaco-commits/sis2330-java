package com.example.empleados.presentation.controller;

import com.example.empleados.application.EmployeeRequest;
import com.example.empleados.application.EmployeeResponse;
import com.example.empleados.application.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public List<EmployeeResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<EmployeeResponse> create(@RequestBody EmployeeRequest request) {
        return ResponseEntity.ok(service.create(request));
    }
}
