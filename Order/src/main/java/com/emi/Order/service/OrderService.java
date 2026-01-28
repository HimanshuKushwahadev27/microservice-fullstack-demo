package com.emi.order.service;

import org.springframework.stereotype.Service;

import com.emi.order.Dtos.RequestOrderDto;
import com.emi.order.Dtos.ResponseOrderDto;
import com.emi.order.Repository.OrderRepo;
import com.emi.order.mapper.OrderMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

	private final OrderMapper orderMapper;
	private final OrderRepo orderRepo;
	
	public ResponseOrderDto placeOrder(RequestOrderDto req) {
		var order=orderMapper.fromReqToOrder(req);
		orderRepo.save(order);
		return new ResponseOrderDto(
				order.getPricePaid(),
				order.getQuantity(),
				order.getSkuCode()
				);
	}
}
