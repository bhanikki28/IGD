package com.anz.bookstore.definitions;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringBootCucumberTestDefinitions {

	private final static String BASE_URI = "http://localhost";

	@LocalServerPort
	private int port;

	private ValidatableResponse validatableResponse;

	private void configureRestAssured() {
		RestAssured.baseURI = BASE_URI;
		RestAssured.port = port;
	}

	protected RequestSpecification requestSpecification() {
		configureRestAssured();
		return given();
	}

	@Given("I send a request to the URL {string} to get list of books")
	public void iSendARequest(String endpoint) throws Throwable {
		validatableResponse = requestSpecification().contentType(ContentType.JSON).when().get(endpoint).then();
		System.out.println("RESPONSE :" + validatableResponse.extract().asString());
	}

	@Then("the response will return status {int}")
	public void extractResponse(int status) {
		validatableResponse.assertThat().statusCode(equalTo(status));
	}
	
	@Given("I send a request to the URL {string} to get book by {string}")
	public void getBookById(String endpoint,String id) throws Throwable {
		validatableResponse = requestSpecification().contentType(ContentType.JSON).when().get(endpoint).then();
		System.out.println("RESPONSE :" + validatableResponse.extract().asString());
	}

	@Then("get book by id will return status {int}")
	public void getBookResponse(int status) {
		validatableResponse.assertThat().statusCode(equalTo(status));
	}

}
