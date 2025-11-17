package com.employee.employeeDepartment.service;

import com.employee.employeeDepartment.entity.Department;
import com.employee.employeeDepartment.exception.ResourceNotFoundException;
import com.employee.employeeDepartment.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository repo;

    public DepartmentService(DepartmentRepository repo) {
        this.repo = repo;
    }

    public Department create(Department department) {
        return repo.save(department);
    }

    public List<Department> getAll() {
        return repo.findAll();
    }

    public Department getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found: " + id));
    }

    public Department update(Long id, Department updated) {
        Department dept = getById(id);
        dept.setName(updated.getName());
        return repo.save(dept);
    }

    public void delete(Long id) {

        getById(id);
        repo.deleteById(id);
    }
}