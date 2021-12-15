package com.reece.demo.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.reece")
public class AddressBookDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddressBookDemoApplication.class, args);
	}

}
