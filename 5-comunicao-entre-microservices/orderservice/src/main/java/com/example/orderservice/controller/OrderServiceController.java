package com.example.orderservice.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.orderservice.entity.Order;

@RestController
@RequestMapping(value = "/v1/orderservice")
public class OrderServiceController {

	public String createOrder(@RequestBody Order order) {
		Order createOrder = null; // item 22.b
		return "Order Status = " + createOrder.getStatus() + ". Total Order is: " + createOrder.getTotalOrder();
	}

}
