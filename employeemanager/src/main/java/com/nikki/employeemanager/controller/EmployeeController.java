package com.nikki.employeemanager.controller;

import com.nikki.employeemanager.model.Employee;
import com.nikki.employeemanager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService empService;

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        System.out.println("Inside Get Employees");
        return empService.getAllEmployees();
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {

        return empService.saveEmployee(employee);

    }

    @GetMapping("/employee/{id}")
    public Employee addEmployee(@PathVariable String id) {

        return empService.getEmployee(Long.valueOf(id));

    }

    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable String id) {

        empService.deleteEmployeee(Long.valueOf(id));

    }

}
