package com.example.employeeservice.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeeservice.model.Employee;
import com.example.employeeservice.model.EmployeeService;


@RestController
@RequestMapping(value = "/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    // @desc      Get all employees
    // @route     GET /api/employees/getEmployees
    // @access    Public
    @GetMapping("/getEmployees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    // @desc      Get employee by ID
    // @route     GET /api/employees/{employeeId}
    // @access    Public
    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable String employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        return employee != null ? 
               new ResponseEntity<>(employee, HttpStatus.OK) : 
               new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // @desc      Add employee
    // @route     POST /api/employees/addEmployee
    // @access    Public
    @PostMapping("/addEmployee")
    public ResponseEntity<Void> addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
