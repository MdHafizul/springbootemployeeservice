package com.example.employeeservice.model;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;



@Service
public class EmployeeService {

    private final List<Employee> employees = new ArrayList<>();

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Employee getEmployeeById(String employeeId) {
        Optional<Employee> optionalEmployee = employees.stream()
                .filter(employee -> employee.getEmployeeID().equals(employeeId))
                .findFirst();
        return optionalEmployee.orElse(null);
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void updateEmployee(String employeeId, Employee employee) {
        for (int i = 0; i < employees.size(); i++) {
            Employee existingEmployee = employees.get(i);
            if (existingEmployee.getEmployeeID().equals(employeeId)) {
                existingEmployee.setFirstName(employee.getFirstName());
                existingEmployee.setLastName(employee.getLastName());
                existingEmployee.setEmail(employee.getEmail());
                existingEmployee.setTitle(employee.getTitle());

                break;
            }
        }
    }

    public void deleteEmployee(String employeeId) {
        employees.removeIf(employee -> employee.getEmployeeID().equals(employeeId));

    }

}