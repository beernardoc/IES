package com.example.app.service.impl;

import com.example.app.entity.Employee;
import com.example.app.repository.EmployeeRepository;
import com.example.app.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class EmployeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;


    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Employee existingEmployee = employeeRepository.findById(employee.getId()).get();
        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        Employee updatedEmployee = employeeRepository.save(existingEmployee);
        return updatedEmployee;

    }

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        return optionalEmployee.get();
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void deleteEmployee(long id) {
        employeeRepository.deleteById(id);

    }
}
