package com.nikki.jpa.demo.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nikki.jpa.demo.entity.EmployeeDetails;
import com.nikki.jpa.demo.exception.ResourceNotFoundException;
import com.nikki.jpa.demo.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1")
@Api(value = "IGD Employee Management", protocols = "http")
public class EmployeeController {
	
    Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService empService;
	
	@ApiOperation(value = "To get the list of employees", response = EmployeeDetails.class, 
			code = 200)
	@GetMapping("/employee")
	public List<EmployeeDetails> getAllEmployees(){
		logger.info("Inside getAllEmployees API");

		return empService.getAllEmployees();
	}
	
	
	@ApiOperation(value = "To access particular employee by passing the employee id", response = EmployeeDetails.class, 
			code = 200)
	@GetMapping(value="/employee/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<EmployeeDetails> getEmployee(@PathVariable String id) throws ResourceNotFoundException {
		logger.info("Inside getEmployee API");
		EmployeeDetails empDetails = empService.getEmployee(id);
		return new ResponseEntity<EmployeeDetails>(empDetails, HttpStatus.OK);
		
	}
	

	@ApiOperation(value = "To create an employee by passing the id,firstName,lastName,emailAddress and designation", response = EmployeeDetails.class, 
			code = 200)
	@PostMapping("/employee")
	public EmployeeDetails addEmployee(@RequestBody EmployeeDetails contact) {
		logger.info("Inside addEmployee API");

		return empService.saveEmployee(contact);
		
	}

}
