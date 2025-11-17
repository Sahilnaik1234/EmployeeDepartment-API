package com.employee.employeeDepartment.repository;

import com.employee.employeeDepartment.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
