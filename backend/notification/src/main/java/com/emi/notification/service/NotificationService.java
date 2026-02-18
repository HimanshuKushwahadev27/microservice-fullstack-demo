package com.emi.notification.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.emi.notification.event.OrderPlaced;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotificationService {

	private final JavaMailSender javaMailSender;

	@KafkaListener(topics="Order-topic")
	public void listen(OrderPlaced orderPlaced) {
		String body = String.format("""
		        Hi %s %s,

		        Your order with the order number %s is successfully delivered.

		        Best regards,
		        EMI
		        """,
		        orderPlaced.getFirstName(),
		        orderPlaced.getLastName(),
		        orderPlaced.getOrderNumber()
		);
		MimeMessagePreparator mimeMessagePresparator = mimeMessage -> {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
			helper.setFrom("springshop@email.con");
			helper.setTo(orderPlaced.getEmail().toString());
			helper.setSubject(String.format("Order Placed successfully " +orderPlaced.getOrderNumber()));
			helper.setText(body,false);
		};
		
		try {
			javaMailSender.send(mimeMessagePresparator);
		}catch(MailException ex) {
			throw new RuntimeException("Mail couldnt be sent to the user");
		}
	}
}
