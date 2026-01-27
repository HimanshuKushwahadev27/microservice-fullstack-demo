package com.emi.order.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emi.order.Dtos.RequestOrderDto;
import com.emi.order.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

	private final OrderService service;
	
	@PostMapping
	public ResponseEntity<String> createOrder(@RequestBody RequestOrderDto req){
		service.placeOrder(req);
		return ResponseEntity.ok("Order  Placed");
	}
}
