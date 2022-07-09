package com.anz.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
public class BookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}
	
	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2)
					.groupName("bookstore-api")
					.apiInfo(apiInfo())
					.select()
					.apis(RequestHandlerSelectors.basePackage("com.nikki.demo.controller"))
					.paths(PathSelectors.any())
					.build();
	}
	
	

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("BookStore API")
				.description("API reference to store/retrieve books")
				.licenseUrl("bharathy.poovalingam@gmail.com")
				.version("1.0")
				.build();
	}


}
