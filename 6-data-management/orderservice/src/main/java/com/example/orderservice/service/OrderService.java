package com.example.orderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.orderservice.entity.Order;
import com.example.orderservice.repository.OrderLineRepository;
import com.example.orderservice.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderLineRepository orderLineRepository;

	public Order getOrder(int orderId) {
		Order order = orderRepository.findById(orderId).get();
		order.setOrderLineList(orderLineRepository.findByOrder(orderId));
		return order;
	}
}
