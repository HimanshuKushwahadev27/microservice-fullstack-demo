package com.emi.inventory;

import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;

import io.restassured.RestAssured;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
class InventoryApplicationTests {

	@LocalServerPort
	private Integer port;
	
	@Test
	void contextLoads() {
	}

	@BeforeEach
	void Init() {
		RestAssured.baseURI="http://localhost";
		RestAssured.port=port;
	}
	
	void shouldGiveBoolean() {
		
		
		RestAssured
		           .given()
		           .queryParam("kuCode", "phone")
		           .queryParam("quantity", "50")
		          .when()
		            .get("/api/inventory")
		           .then()
		              .statusCode(200)
		              .body(equalTo("true"))
		              ;
		         
	}
	
}
