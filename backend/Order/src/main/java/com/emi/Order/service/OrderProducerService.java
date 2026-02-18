package com.emi.Order.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.emi.Order.event.OrderPlaced;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderProducerService {

	private final KafkaTemplate<String, OrderPlaced> kafkaEvent;
	
	public void sendOrderEvent(OrderPlaced event) {
		kafkaEvent.send("Order-topic", event);
	}
}
