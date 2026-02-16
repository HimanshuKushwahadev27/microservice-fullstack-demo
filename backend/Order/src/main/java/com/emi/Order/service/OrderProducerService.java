package com.emi.Order.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.emi.Order.event.OrderEvent;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderProducerService {

	private final KafkaTemplate<String, OrderEvent> kafkaEvent;
	
	public void sendOrderEvent(OrderEvent event) {
		kafkaEvent.send("Order-topic", event);
	}
}
