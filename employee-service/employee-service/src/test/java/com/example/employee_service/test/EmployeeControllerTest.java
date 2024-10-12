package com.example.employee_service.test;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.employeeservice.model.Employee;
import com.example.employeeservice.model.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

// Include the configuration for the test context
@WebMvcTest
@ContextConfiguration(classes = com.example.employeeservice.EmployeeServiceApplication.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        Employee employee = new Employee("1", "John", "Doe", "john.doe@example.com", "Manager");
        when(employeeService.getAllEmployees()).thenReturn(Collections.singletonList(employee));
        when(employeeService.getEmployeeById("1")).thenReturn(employee);
    }

    @Test
    public void testGetAllEmployees() throws Exception {
        mockMvc.perform(get("/api/employees/getEmployees"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].firstName").value("John"));
    }

    @Test
    public void testAddEmployee() throws Exception {
        Employee employee = new Employee("1", "Jane", "Smith", "jane.smith@example.com", "Director");
        doNothing().when(employeeService).addEmployee(any(Employee.class));

        mockMvc.perform(post("/api/employees/addEmployee")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(employee)))
                .andExpect(status().isCreated());
    }
}
