package com.example.orderservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.orderservice.entity.Order;
import com.example.orderservice.entity.OrderLine;
import com.example.orderservice.entity.Product;

@Service
public class OrderService {

	@Autowired
	private DiscoveryClient discoveryClient;

	public Order createOrder(Order order) {
		for (OrderLine orderLine : order.getOrderLineList()) {
			Product product = getProductFromService(orderLine);
			order.setTotalOrder(order.getTotalOrder() + (orderLine.getQuantity() * product.getPrice()));
		}
		order.setStatus("Created");
		return order;
	}

	private Product getProductFromService(OrderLine orderLine) {
		List<ServiceInstance> instances = discoveryClient.getInstances("productservice");
		Product product = null;
		if (instances.size() == 0) {
			throw new RuntimeException();
		} else {
			RestTemplate restTemplate = new RestTemplate();
			String uri = String.format("%s/v1/productservice/product/%s", instances.get(0).getUri().toString(),
					orderLine.getProductId());
			ResponseEntity<Product> restExchange = restTemplate.exchange(uri, HttpMethod.GET, null, Product.class,
					orderLine.getProductId());
			product = restExchange.getBody();
		}
		return product;
	}

}
