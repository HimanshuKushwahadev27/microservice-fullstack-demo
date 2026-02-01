package com.emi.api_gateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class FallBackController {

    @RequestMapping(
            value = "/fallback/product",
            method = {
                RequestMethod.GET,
                RequestMethod.POST,
                RequestMethod.PUT,
                RequestMethod.DELETE,
                RequestMethod.PATCH
            }
        )
	public Mono<ResponseEntity<String>> productServiceFallBack() {
		return Mono.just(
            ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body("product service is down")
        );
	}
	
    @RequestMapping(
            value = "/fallback/order",
            method = {
                RequestMethod.GET,
                RequestMethod.POST,
                RequestMethod.PUT,
                RequestMethod.DELETE,
                RequestMethod.PATCH
            }
        )
	public Mono<ResponseEntity<String>> orderServiceFallBack() {
		return Mono.just(
	            ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
	                .body("order service is down")
	        );
	}
	
    @RequestMapping(
            value = "/fallback/inventory",
            method = {
                RequestMethod.GET,
                RequestMethod.POST,
                RequestMethod.PUT,
                RequestMethod.DELETE,
                RequestMethod.PATCH
            }
        )
	public Mono<ResponseEntity<String>> inventoryServiceFallBack() {
		return Mono.just(
            ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body("Inventory service is down")
        );
	}
	
	
}
