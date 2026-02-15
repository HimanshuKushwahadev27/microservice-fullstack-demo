package com.emi.Order;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;
import io.restassured.RestAssured;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrderApplicationTests {

	@LocalServerPort
	private Integer port;
	

	
	@BeforeEach
	void setUp() {
		RestAssured.baseURI="http://localhost";
		RestAssured.port=8082;
	}
	
	@Test
	void shouldCreateOrder() {
		String request="""
				{
				    "pricePaid":"1500",
				    "quantity":"10",
				    "skuCode":"phone"
				}
				""";
		
		RestAssured.given()
		
		         .contentType("application/json")
		         .body(request)
		       .when()
		           .post("/api/order")
		       .then()
		            .statusCode(200)
		            .log().all()
		  
		            .body("pricePaid", Matchers.equalTo(1500))
		            .body("quantity", Matchers.equalTo(10))
		            .body("skuCode",Matchers.equalTo("phone"))
		            
		            ;
	}

}
