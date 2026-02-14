package com.emi.order.Dtos;

import java.math.BigDecimal;

public record ResponseOrderDto(
		BigDecimal pricePaid,
		Integer quantity,
		String skuCode) {

}
