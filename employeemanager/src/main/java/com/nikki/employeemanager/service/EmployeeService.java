package com.nikki.employeemanager.service;

import com.nikki.employeemanager.model.Employee;
import com.nikki.employeemanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository empRepository;

    public List<Employee> getAllEmployees(){
        return empRepository.findAll();
    }

    public Employee saveEmployee(Employee employee) {
         return empRepository.save(employee);
    }

    public Employee getEmployee(Long id) {
        return empRepository.getById(id);
    }

    public void deleteEmployeee(Long id) {
        empRepository.deleteById(id);
    }

}
