package com.emi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.emi.client.InventoryClient;
import com.emi.dto.RequestProductDto;
import com.emi.dto.ResponseProductDto;
import com.emi.mapper.ProductMapper;
import com.emi.repo.ProductRepo;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class ProductService {

	private final ProductRepo repo;
	private final ProductMapper mapper;
	private final InventoryClient client;
	
	public ResponseProductDto createProduct(RequestProductDto req) {
		
		var product=mapper.fromRequestToProduct(req);
		repo.save(product);
		client.updateInventory(req.getName(),req.getQuantity());
		log.info("Product created with {}" + product.getId());
		return mapper.fromProductToResponse(product);
	}
	
	public List<ResponseProductDto> allProduct(){
		var  products=repo.findAll();	
		return products.stream().map(mapper::fromProductToResponse).toList();
	}
}
