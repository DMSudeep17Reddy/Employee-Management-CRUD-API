package net.javaguides.employeemanagement.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.javaguides.employeemanagement.dto.EmployeeDto;
import net.javaguides.employeemanagement.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private EmployeeService employeeService;

    @Test
    void getAllEmployeesTest() throws Exception {

        EmployeeDto employee =
                new EmployeeDto(1L,
                        "Sudeep",
                        "Reddy",
                        "sudeep@gmail.com");

        Mockito.when(employeeService.getAllEmployees())
                .thenReturn(Arrays.asList(employee));

        mockMvc.perform(get("/api/employees"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].firstName").value("Sudeep"))
                .andExpect(jsonPath("$[0].lastName").value("Reddy"))
                .andExpect(jsonPath("$[0].email").value("sudeep@gmail.com"));
    }

    @Test
    void getEmployeeByIdTest() throws Exception {

        EmployeeDto employee =
                new EmployeeDto(1L,
                        "Sudeep",
                        "Reddy",
                        "sudeep@gmail.com");

        Mockito.when(employeeService.getEmployeeById(1L))
                .thenReturn(employee);

        mockMvc.perform(get("/api/employees/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.firstName").value("Sudeep"))
                .andExpect(jsonPath("$.lastName").value("Reddy"))
                .andExpect(jsonPath("$.email").value("sudeep@gmail.com"));
    }

    @Test
    void createEmployeeTest() throws Exception {

        EmployeeDto employee =
                new EmployeeDto(1L,
                        "Sudeep",
                        "Reddy",
                        "sudeep@gmail.com");

        Mockito.when(employeeService.createEmployee(Mockito.any(EmployeeDto.class)))
                .thenReturn(employee);

        mockMvc.perform(post("/api/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(employee)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.firstName").value("Sudeep"));
    }

    @Test
    void updateEmployeeTest() throws Exception {

        EmployeeDto employee =
                new EmployeeDto(1L,
                        "Updated",
                        "Reddy",
                        "updated@gmail.com");

        Mockito.when(employeeService.updateEmployee(Mockito.eq(1L), Mockito.any(EmployeeDto.class)))
                .thenReturn(employee);

        mockMvc.perform(put("/api/employees/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(employee)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Updated"))
                .andExpect(jsonPath("$.email").value("updated@gmail.com"));
    }

    @Test
    void deleteEmployeeTest() throws Exception {

        mockMvc.perform(delete("/api/employees/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Employee deleted successfully"));
    }
}