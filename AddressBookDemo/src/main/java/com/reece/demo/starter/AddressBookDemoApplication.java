package com.reece.demo.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@SpringBootApplication(scanBasePackages = "com.reece")
public class AddressBookDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddressBookDemoApplication.class, args);
	}

	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("address-book-api")
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.reece.demo.controller"))
				.paths(PathSelectors.any())
				.build();
	}



	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Address Book API")
				.description("Spring Rest API reference")
				.licenseUrl("bharathy.poovalingam@gmail.com")
				.version("1.0")
				.build();
	}

}
