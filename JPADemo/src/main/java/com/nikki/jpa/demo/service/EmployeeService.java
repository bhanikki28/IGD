package com.nikki.jpa.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.nikki.jpa.demo.entity.EmployeeDetails;
import com.nikki.jpa.demo.exception.ResourceNotFoundException;
import com.nikki.jpa.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
    Logger logger = LoggerFactory.getLogger(EmployeeService.class);


	private final EmployeeRepository employeeRepo;
	
	public EmployeeService(EmployeeRepository employeeRepo) {
		this.employeeRepo = employeeRepo;
	}
	
	public List<EmployeeDetails> getAllEmployees(){
		logger.info("Inside EmployeeService::getAllEmployees");

		return employeeRepo.findAll();
	}
	
	public EmployeeDetails getEmployee(String id) throws ResourceNotFoundException{
		logger.info("Inside EmployeeService::getEmployee");
		EmployeeDetails emp = null;
		try {
		emp = employeeRepo.getById(id);
		logger.info("Fetching the employee detail for {}", emp.toString());
		}
		
		catch(Exception e) {
			throw new ResourceNotFoundException("Employee not found", "404");
		}
		
		return emp;
	}
	
	public EmployeeDetails saveEmployee(EmployeeDetails employee) {
		logger.info("Inside EmployeeService::saveEmployee");

		return employeeRepo.save(employee);
		
	}

	

}
