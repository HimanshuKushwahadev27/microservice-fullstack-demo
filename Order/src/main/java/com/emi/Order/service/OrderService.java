package com.emi.order.service;

import org.springframework.stereotype.Service;

import com.emi.order.Dtos.RequestOrderDto;
import com.emi.order.Dtos.ResponseOrderDto;
import com.emi.order.Repository.OrderRepo;
import com.emi.order.client.InventoryServiceClient;
import com.emi.order.exception.OutOfStockException;
import com.emi.order.mapper.OrderMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

	private final OrderMapper orderMapper;
	private final OrderRepo orderRepo;
	private final InventoryServiceClient client;
	
	
	public ResponseOrderDto placeOrder(RequestOrderDto req) {
		var order=orderMapper.fromReqToOrder(req);
		
		if(client.checkInventory(req.skuCode(), req.quantity())) {
		orderRepo.save(order);
		return new ResponseOrderDto(
				order.getPricePaid(),
				order.getQuantity(),
				order.getSkuCode()
				);
		}else {
			throw new OutOfStockException("product is out of stock");
		}
	}
}
