package com.example.demo.sender;

import java.util.concurrent.TimeUnit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import com.example.demo.SpringAmpqApplication;
import com.example.demo.receiver.Receiver;

@Component
public class Sender {

	private final RabbitTemplate rabbitTemplate;
	private final Receiver receiver;
	private final ConfigurableApplicationContext context;

	public Sender(Receiver receiver, RabbitTemplate rabbitTemplate,
			ConfigurableApplicationContext context) {
		this.receiver = receiver;
		this.rabbitTemplate = rabbitTemplate;
		this.context = context;
	}

	
	public void sendMessage(String message) throws Exception {
		System.out.println("Sending message...");
		rabbitTemplate.convertAndSend(SpringAmpqApplication.queueName, "Hello from RabbitMQ!");
		receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
		context.close();
	}

}
