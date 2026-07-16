package net.javaguides.employeemanagement.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import net.javaguides.employeemanagement.dto.EmployeeDto;
import net.javaguides.employeemanagement.entity.Employee;
import net.javaguides.employeemanagement.exception.ResourceNotFoundException;
import net.javaguides.employeemanagement.repository.EmployeeRepository;
import net.javaguides.employeemanagement.service.impl.EmployeeServiceImpl;


class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;


    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void createEmployee_ShouldReturnEmployeeDto() {

        EmployeeDto employeeDto =
                new EmployeeDto(null, "Sudeep", "Reddy", "sudeep@gmail.com");


        Employee savedEmployee =
                new Employee(1L, "Sudeep", "Reddy", "sudeep@gmail.com");


        when(employeeRepository.save(any(Employee.class)))
                .thenReturn(savedEmployee);


        EmployeeDto result =
                employeeService.createEmployee(employeeDto);


        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Sudeep", result.getFirstName());
        assertEquals("Reddy", result.getLastName());
        assertEquals("sudeep@gmail.com", result.getEmail());


        verify(employeeRepository, times(1))
                .save(any(Employee.class));
    }



    @Test
    void getEmployeeById_ShouldReturnEmployee() {

        Employee employee =
                new Employee(1L,
                        "Sudeep",
                        "Reddy",
                        "sudeep@gmail.com");


        when(employeeRepository.findById(1L))
                .thenReturn(Optional.of(employee));


        EmployeeDto result =
                employeeService.getEmployeeById(1L);


        assertEquals(1L, result.getId());
        assertEquals("Sudeep", result.getFirstName());

        verify(employeeRepository)
                .findById(1L);
    }



    @Test
    void getEmployeeById_WhenEmployeeNotFound_ShouldThrowException() {


        when(employeeRepository.findById(10L))
                .thenReturn(Optional.empty());


        assertThrows(ResourceNotFoundException.class,
                () -> employeeService.getEmployeeById(10L));


        verify(employeeRepository)
                .findById(10L);
    }



    @Test
    void getAllEmployees_ShouldReturnEmployeeList() {


        List<Employee> employees = Arrays.asList(
                new Employee(1L,
                        "Sudeep",
                        "Reddy",
                        "sudeep@gmail.com"),

                new Employee(2L,
                        "John",
                        "Smith",
                        "john@gmail.com")
        );


        when(employeeRepository.findAll())
                .thenReturn(employees);


        List<EmployeeDto> result =
                employeeService.getAllEmployees();


        assertEquals(2, result.size());

        verify(employeeRepository)
                .findAll();
    }



    @Test
    void updateEmployee_ShouldUpdateEmployee() {


        Employee existingEmployee =
                new Employee(1L,
                        "Old",
                        "Name",
                        "old@gmail.com");


        EmployeeDto updatedDto =
                new EmployeeDto(1L,
                        "Sudeep",
                        "Reddy",
                        "sudeep@gmail.com");


        when(employeeRepository.findById(1L))
                .thenReturn(Optional.of(existingEmployee));


        when(employeeRepository.save(any(Employee.class)))
                .thenReturn(existingEmployee);



        EmployeeDto result =
                employeeService.updateEmployee(1L, updatedDto);



        assertEquals("Sudeep",
                result.getFirstName());

        assertEquals("Reddy",
                result.getLastName());


        verify(employeeRepository)
                .save(any(Employee.class));
    }



    @Test
    void deleteEmployee_ShouldDeleteEmployee() {


        Employee employee =
                new Employee(1L,
                        "Sudeep",
                        "Reddy",
                        "sudeep@gmail.com");


        when(employeeRepository.findById(1L))
                .thenReturn(Optional.of(employee));


        employeeService.deleteEmployee(1L);


        verify(employeeRepository)
                .delete(employee);
    }

}