package com.emi.Order.Dtos;

import java.math.BigDecimal;

public record ResponseOrderDto(
		BigDecimal pricePaid,
		Integer quantity,
		String skuCode) {

}
