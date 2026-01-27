package com.emi.order.Dtos;

import java.math.BigDecimal;

public record RequestOrderDto(

		BigDecimal pricePaid,
		Integer quantity,
		String skuCode
		
		) {

	
}
