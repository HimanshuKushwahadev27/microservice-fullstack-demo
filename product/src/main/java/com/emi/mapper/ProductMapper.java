package com.emi.mapper;

import org.springframework.stereotype.Component;

import com.emi.dto.RequestProductDto;
import com.emi.entity.Product;

@Component
public class ProductMapper {

	public Product fromRequestToProduct(RequestProductDto req) {
		return Product.builder()
				.name(req.getProductName())
				.description(req.getDescription())
				.price(req.getPrice())
				.build()
				;
	}
}
