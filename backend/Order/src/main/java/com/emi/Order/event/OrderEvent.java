package com.emi.Order.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEvent {
	private Long Id;
	private String userEMail;
	
	private String status;
	
}
