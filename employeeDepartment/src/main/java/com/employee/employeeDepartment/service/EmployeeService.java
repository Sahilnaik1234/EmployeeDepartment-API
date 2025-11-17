package com.employee.employeeDepartment.service;

import com.employee.employeeDepartment.entity.Employee;
import com.employee.employeeDepartment.exception.ResourceNotFoundException;
import com.employee.employeeDepartment.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepo;

    public Employee saveEmployee(Employee emp) {
        return employeeRepo.save(emp);
    }
    public Employee create(Employee employee) {

        return employeeRepo.save(employee);
    }

    public List<Employee> getAll() {
        return employeeRepo.findAll();
    }

    public Employee getById(Long id) {
        return employeeRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
    }

    public Employee update(Long id, Employee newEmp) {
        return employeeRepo.findById(id)
                .map(emp -> {
                    emp.setName(newEmp.getName());
                    emp.setEmail(newEmp.getEmail());
                    emp.setSalary(newEmp.getSalary());
                    emp.setDepartment(newEmp.getDepartment());
                    return employeeRepo.save(emp);
                }).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public void delete(Long id) {
        employeeRepo.deleteById(id);
    }

}

