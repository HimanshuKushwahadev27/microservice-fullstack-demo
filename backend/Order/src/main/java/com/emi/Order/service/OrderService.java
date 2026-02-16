package com.emi.Order.service;

import org.springframework.stereotype.Service;

import com.emi.Order.Dtos.RequestOrderDto;
import com.emi.Order.Dtos.ResponseOrderDto;
import com.emi.Order.Repository.OrderRepo;
import com.emi.Order.client.InventoryServiceClient;
import com.emi.Order.event.OrderEvent;
import com.emi.Order.exception.OutOfStockException;
import com.emi.Order.mapper.OrderMapper;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

	private final OrderMapper orderMapper;
	private final OrderRepo orderRepo;
	private final InventoryServiceClient client;
	private final OrderProducerService orderProducer;
	
	@Transactional
	public ResponseOrderDto placeOrder(RequestOrderDto req, String email) {
		var order=orderMapper.fromReqToOrder(req);
		
		if(client.checkInventory(req.skuCode(), req.quantity())) {
		orderRepo.save(order);
		
		OrderEvent orderEvent = new OrderEvent(
				order.getId(),
				email,
				"Order_placed"
				);
		orderProducer.sendOrderEvent(orderEvent);
		
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
