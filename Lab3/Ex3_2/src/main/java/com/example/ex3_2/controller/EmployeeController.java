package com.example.ex3_2.controller;


import com.example.ex3_2.service.EmployeeService;
import com.example.ex3_2.entity.Employee;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("api/employees")
public class EmployeeController {

    private EmployeeService employeeService;


    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee createdEmployee = employeeService.createEmployee(employee);
        return new ResponseEntity<>(createdEmployee, org.springframework.http.HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getUserById(@PathVariable("id") Long employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees,HttpStatus.OK);
    }

    // Build Update User REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/users/1
    public ResponseEntity<Employee> updateUser(@PathVariable("id") Long userId,
                                               @RequestBody Employee employee){
        employee.setId(userId);
        Employee updatedEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    // Build Delete User REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long userId){
        employeeService.deleteEmployee(userId);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }

    @GetMapping("/byemail")
    public ResponseEntity<List<Employee>> findByEmail(@RequestParam String email){
        if(email == null || email.isEmpty()){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        List<Employee> employees = employeeService.findByEmail(email);
        return new ResponseEntity<>(employees,HttpStatus.OK);
    }

}