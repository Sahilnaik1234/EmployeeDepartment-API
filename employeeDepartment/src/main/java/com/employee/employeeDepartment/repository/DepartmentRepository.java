package com.employee.employeeDepartment.repository;

import com.employee.employeeDepartment.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
