package com.emi.Order.service;

import org.springframework.stereotype.Service;

import com.emi.Order.Dtos.RequestOrderDto;
import com.emi.Order.Dtos.ResponseOrderDto;
import com.emi.Order.Repository.OrderRepo;
import com.emi.Order.client.InventoryServiceClient;
import com.emi.Order.exception.OutOfStockException;
import com.emi.Order.mapper.OrderMapper;

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
