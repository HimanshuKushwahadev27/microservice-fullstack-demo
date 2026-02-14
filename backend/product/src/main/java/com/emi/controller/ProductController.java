package com.emi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.emi.dto.RequestProductDto;
import com.emi.dto.ResponseProductDto;
import com.emi.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

	private final ProductService service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseProductDto createProduct(@RequestBody RequestProductDto request) {
		return service.createProduct(request);	
	}
	

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<ResponseProductDto> allProducts(){
		return service.allProduct();
	}
}
