package com.nikki.jpa.demo.jpa.test;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.nikki.jpa.demo.entity.EmployeeDetails;
import com.nikki.jpa.demo.repository.EmployeeRepository;
@RunWith(SpringRunner.class)
@DataJpaTest
public class JPAUnitTest {
	
	 
	 @Autowired
	 private EmployeeRepository empRepository;
	 
	 @Test
	 public void getAllEmployees() {
		 
		 Iterable<EmployeeDetails> empList = empRepository.findAll();
		 assertThat(empList).hasSize(4);
	 }

}
