package com.example.orderservice.service;

import org.springframework.stereotype.Service;

import com.example.orderservice.entity.Order;
import com.example.orderservice.entity.PaymentInfo;
import com.example.orderservice.utils.RandomUtils;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class OrderService {

	public Order getOrder(int orderId) {
		return new Order(orderId);
	}

	@HystrixCommand(fallbackMethod = "getPaymentInfoFallback")
	public PaymentInfo getPaymentInfo(Order order) {
		PaymentInfo paymentInfo = null;
		if (RandomUtils.random50PercentError() == 1) {
			throw new RuntimeException();
		} else {
			paymentInfo = new PaymentInfo();
		}
		return paymentInfo;
	}

	public PaymentInfo getPaymentInfoFallback(Order order, Throwable e) {
		return new PaymentInfo("No information available about payments : " + e.getClass().getSimpleName());
	}

	@HystrixCommand(fallbackMethod = "getTotalItemFallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000") })
	public int getTotalItem(Order order) {
		if (RandomUtils.random50PercentError() == 1) {
			RandomUtils.randomSleep();
		}
		return RandomUtils.randomTotalItems();
	}

	public int getTotalItemFallback(Order order) {
		return -1;
	}

}
