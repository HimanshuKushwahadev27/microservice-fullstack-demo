package com.emi.microservices.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;

import static io.restassured.http.Method.GET;

import java.util.Collections;


import io.restassured.RestAssured;

import org.hamcrest.Matchers;



@Import({TestcontainersConfiguration.class , TestConfig.class})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductApplicationTests {
	
	@LocalServerPort
	private Integer port;
	

	
	@BeforeEach
	void setUp() {
	RestAssured.baseURI="http://localhost";
	RestAssured.port=port;
    RestAssured.filters(Collections.emptyList());

	}
	
	@Test
	void shouldCreateProduct() {
		String requestBody = """
				       {
					    "name" : "sofa",
					    "description": "A comforting place where u can sleep",
					    "price": 150
                        }
				""";
		RestAssured.given()
		                .contentType("application/json")
		                .body(requestBody)
		            .when()
		                .post("/api/product")
		            .then()
		                .log().all()
		            	.statusCode(201)
		            	.body("name", Matchers.equalTo("sofa"))
		            	.body("description", Matchers.equalTo("A comforting place where u can sleep"))
		            	.body("price", Matchers.equalTo(150));          
	}
	
	@Test
	void shoudReturn() {
		
		String request="""
				
				{					  
				        "name" : "sofa",
					    "description": "A comforting place where u can sleep",
					    "price": 150
				}
		""";
		
		
		for(int i=0 ; i<10 ; i++) {
						RestAssured.given()
			            .contentType("application/json")
			            .body(request)
			        .when()
			            .post("/api/product")
			        .then()
			            .log().all()
			        	.statusCode(201)
        	;
		}
		

		RestAssured   
		               .given()
		                   .accept("application/json")
		                   .request(GET, "/api/product")
		                   .then()
		                   .log().all()
		                   .statusCode(200)
		                   .body("$", Matchers.hasSize(Matchers.greaterThan(0)));
	}
}
