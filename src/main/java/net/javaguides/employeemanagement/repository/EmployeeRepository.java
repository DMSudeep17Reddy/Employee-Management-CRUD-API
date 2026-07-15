package net.javaguides.employeemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import net.javaguides.employeemanagement.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}