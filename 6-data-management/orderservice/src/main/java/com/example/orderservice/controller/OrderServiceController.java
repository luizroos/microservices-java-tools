package com.example.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.orderservice.entity.Order;
import com.example.orderservice.service.OrderService;

@RestController
@RequestMapping(value = "/v1/orderservice")
public class OrderServiceController {

	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "/{orderId}", method = RequestMethod.GET)
	public Order getOrder(@PathVariable(name = "orderId") int orderId) {
		return orderService.getOrder(orderId);
	}

}
