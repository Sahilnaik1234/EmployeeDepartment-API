package com.employee.employeeDepartment.controller;

import com.employee.employeeDepartment.entity.Department;
import com.employee.employeeDepartment.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private static final Logger log = LoggerFactory.getLogger(DepartmentController.class);
    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Department> create(@Valid @RequestBody Department department) {
        log.info("Create Department: {}", department.getName());
        return ResponseEntity.ok(service.create(department));
    }

    @GetMapping
    public List<Department> getAll() {
        log.info("Get all departments");
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Department getById(@PathVariable Long id) {
        log.info("Get department {}", id);
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Department update(
            @PathVariable Long id,
            @Valid @RequestBody Department department) {

        log.info("Update department {}", id);
        return service.update(id, department);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.warn("Delete department {}", id);
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}