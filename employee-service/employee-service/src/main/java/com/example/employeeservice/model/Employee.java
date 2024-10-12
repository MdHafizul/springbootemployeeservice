package com.example.employeeservice.model;

public class Employee {
    private String employeeID;
    private String firstName;
    private String lastName;
    private String email;
    private String title;

    public Employee(String employeeID, String firstName, String lastName, String email, String title) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.title = title;
    }

    public String getEmployeeID() {
        return employeeID;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }
    public String getTitle() {
        return title;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String toString(){
        return "Employee ID: " + employeeID + " First Name: " + firstName + " Last Name: " + lastName + " Email: " + email + " Title: " + title;
    }
    
}
