package com.emi.Order.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emi.Order.Dtos.RequestOrderDto;
import com.emi.Order.Dtos.ResponseOrderDto;
import com.emi.Order.service.OrderService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

	private final OrderService service;
	
	@PostMapping
	public ResponseEntity<ResponseOrderDto> createOrder(@RequestBody RequestOrderDto req){
		return ResponseEntity.ok(service.placeOrder(req));
	}
}
