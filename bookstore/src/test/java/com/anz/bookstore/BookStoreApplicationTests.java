package com.anz.bookstore;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import io.cucumber.java.BeforeAll;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class BookStoreApplicationTests {

	private final static String BASE_URI = "http://localhost";
	
	@LocalServerPort
	private int port;
	
	 @BeforeAll
    public void configureRestAssured() {
        RestAssured.baseURI = BASE_URI;
        RestAssured.port = port;
    }
 
    @Test
    public void searchBookByName() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/bookstore/v1/books?name=GCP*")
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("GCP Architect Course", response.jsonPath().getString("bookName[0]"));
    }
    
    
    
}
