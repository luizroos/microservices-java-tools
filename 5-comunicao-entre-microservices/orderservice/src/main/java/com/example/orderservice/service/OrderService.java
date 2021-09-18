package com.example.orderservice.service;

import java.util.List;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.example.orderservice.cache.MySimpleCache;
import com.example.orderservice.entity.Order;
import com.example.orderservice.entity.OrderLine;
import com.example.orderservice.entity.Product;

@Service
public class OrderService {

	public Order createOrder(Order order) {
		for (OrderLine orderLine : order.getOrderLineList()) {
			Product product = getProductFromService(orderLine);
			order.setTotalOrder(order.getTotalOrder() + (orderLine.getQuantity() * product.getPrice()));
		}
		order.setStatus("Created");
		return order;
	}

	private Product getProductFromService(OrderLine orderLine) {
		List<ServiceInstance> instances = null;
		Product product = null;
		if (instances.size() == 0) {
			throw new RuntimeException();
		} else {

		}
		return product;
	}

}
