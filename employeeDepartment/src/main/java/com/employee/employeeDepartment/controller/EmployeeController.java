package com.employee.employeeDepartment.controller;

import com.employee.employeeDepartment.entity.Employee;
import com.employee.employeeDepartment.service.EmployeeService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    public Employee create(@Valid @RequestBody Employee employee) {
        log.info("Create employee {}", employee.getName());

        return service.create(employee);
    }

    @GetMapping
    public List<Employee> getAll() {
        log.info("Fetch all employees");
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id) {
        log.info("Fetch employee {}", id);
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @Valid @RequestBody Employee employee) {
        log.info("Update employee {}", id);
        return service.update(id, employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.warn("Delete employee {}", id);
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}