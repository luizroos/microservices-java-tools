package com.example.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.orderservice.entity.Order;
import com.example.orderservice.entity.PaymentInfo;
import com.example.orderservice.service.OrderService;

@RestController
@RequestMapping(value = "/v1/orderservice")
public class OrderServiceController {

	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "/getPaymentoInfo/{orderId}", method = RequestMethod.GET)
	public PaymentInfo getPaymentInfo(@PathVariable(name = "orderId") int orderId) {
		Order order = orderService.getOrder(orderId);
		PaymentInfo paymentInfo = orderService.getPaymentInfo(order);
		return paymentInfo;
	}

	@RequestMapping(value = "/getItems/{orderId}", method = RequestMethod.GET)
	public int getTotalItem(@PathVariable(name = "orderId") int orderId) {
		Order order = orderService.getOrder(orderId);
		int totalItem = orderService.getTotalItem(order);
		return totalItem;
	}

}
