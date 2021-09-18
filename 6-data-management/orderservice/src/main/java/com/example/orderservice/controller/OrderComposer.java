package com.example.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.orderservice.service.OrderComposerService;
import com.example.orderservice.vo.OrderComposerVO;

@RestController
@RequestMapping(value = "/v1/ordercomposer")
public class OrderComposer {

	@Autowired
	private OrderComposerService orderComposerService;

	@RequestMapping(value = "/{orderId}", method = RequestMethod.GET)
	public OrderComposerVO getOrder(@PathVariable(name = "orderId") int orderId) {
		return orderComposerService.getOrder(orderId);
	}

}
