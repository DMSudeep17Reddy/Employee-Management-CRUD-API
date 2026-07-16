package net.javaguides.employeemanagement.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import net.javaguides.employeemanagement.dto.EmployeeDto;
import net.javaguides.employeemanagement.entity.Employee;
import net.javaguides.employeemanagement.exception.ResourceNotFoundException;
import net.javaguides.employeemanagement.repository.EmployeeRepository;
import net.javaguides.employeemanagement.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger logger =
            LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private final EmployeeRepository employeeRepository;

    // Constructor Injection
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        logger.info("Creating employee with email: {}", employeeDto.getEmail());

        Employee employee = new Employee();

        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());

        Employee savedEmployee = employeeRepository.save(employee);

        logger.info("Employee created successfully with id: {}", savedEmployee.getId());

        return new EmployeeDto(
                savedEmployee.getId(),
                savedEmployee.getFirstName(),
                savedEmployee.getLastName(),
                savedEmployee.getEmail()
        );
    }


    @Override
    public EmployeeDto getEmployeeById(Long id) {

        logger.info("Fetching employee with id: {}", id);

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> {
                    logger.warn("Employee not found with id: {}", id);
                    return new ResourceNotFoundException(
                            "Employee not found with id: " + id);
                });

        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }


    @Override
    public List<EmployeeDto> getAllEmployees() {

        logger.info("Fetching all employees");

        List<Employee> employees = employeeRepository.findAll();

        logger.info("Total employees found: {}", employees.size());

        return employees.stream()
                .map(employee -> new EmployeeDto(
                        employee.getId(),
                        employee.getFirstName(),
                        employee.getLastName(),
                        employee.getEmail()
                ))
                .collect(Collectors.toList());
    }


    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {

        logger.info("Updating employee with id: {}", id);

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> {
                    logger.warn("Employee not found with id: {}", id);
                    return new ResourceNotFoundException(
                            "Employee not found with id: " + id);
                });


        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());


        Employee updatedEmployee = employeeRepository.save(employee);

        logger.info("Employee updated successfully with id: {}",
                updatedEmployee.getId());


        return new EmployeeDto(
                updatedEmployee.getId(),
                updatedEmployee.getFirstName(),
                updatedEmployee.getLastName(),
                updatedEmployee.getEmail()
        );
    }


    @Override
    public void deleteEmployee(Long id) {

        logger.info("Deleting employee with id: {}", id);

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> {
                    logger.warn("Employee not found with id: {}", id);
                    return new ResourceNotFoundException(
                            "Employee not found with id: " + id);
                });


        employeeRepository.delete(employee);

        logger.info("Employee deleted successfully with id: {}", id);
    }

}