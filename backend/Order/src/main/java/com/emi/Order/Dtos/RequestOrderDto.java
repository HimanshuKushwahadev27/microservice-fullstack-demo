package com.emi.Order.Dtos;

import java.math.BigDecimal;

public record RequestOrderDto(

		BigDecimal pricePaid,
		Integer quantity,
		String skuCode
		
		) {

	
}
