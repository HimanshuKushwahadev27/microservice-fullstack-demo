package com.emi.mapper;

import org.springframework.stereotype.Component;

import com.emi.dto.RequestProductDto;
import com.emi.entity.Product;
import com.emi.dto.ResponseProductDto;

@Component
public class ProductMapper {

	public Product fromRequestToProduct(RequestProductDto req) {
		return Product.builder()
				.skuCode(req.getSkuCode())
				.name(req.getName())
				.description(req.getDescription())
				.price(req.getPrice())
				.quantity(req.getQuantity())
				.build()
				
				;
	}

	public ResponseProductDto fromProductToResponse(Product product) {
		return com.emi.dto.ResponseProductDto.builder()
				.skuCode(product.getSkuCode())
				.name(product.getName())
				.description(product.getDescription())
				.price(product.getPrice())
				.quantity(product.getQuantity())
				.build();
	}
}
