package com.emi.Order.mapper;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.emi.Order.Dtos.RequestOrderDto;
import com.emi.Order.entity.Order;

@Component
public class OrderMapper {

	public Order fromReqToOrder(RequestOrderDto req) {
		return Order.builder()
				.pricePaid(req.pricePaid())
				.quantity(req.quantity())
				.orderNumber(UUID.randomUUID().toString())
				.skuCode(req.skuCode())
				.build();
		
	}


}
