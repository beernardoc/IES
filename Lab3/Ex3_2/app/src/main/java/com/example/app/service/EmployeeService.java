package com.example.app.service;

import com.example.app.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee createEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    Employee getEmployeeById(long id);

    List<Employee> getAllEmployees();

    void deleteEmployee(long id);



}
