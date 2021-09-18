package com.example.orderservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.orderservice.entity.Payment;
import com.example.orderservice.entity.Product;
import com.example.orderservice.vo.OrderComposerVO;

@Service
public class OrderComposerService {

	@Autowired
	private DiscoveryClient discoveryClient;

	@Autowired
	private OrderService orderService;

	public OrderComposerVO getOrder(int orderId) {
		return null;
	}

	private Product getProduct(int productId) {
		RestTemplate restTemplate = new RestTemplate();
		String uri = String.format("%s/v1/productservice/%s", getServiceInstanceURI("productservice"), productId);
		ResponseEntity<Product> restExchange = restTemplate.exchange(uri, HttpMethod.GET, null, Product.class,
				productId);
		return restExchange.getBody();
	}

	private Payment getPayment(int orderId) {
		RestTemplate restTemplate = new RestTemplate();
		String uri = String.format("%s/v1/paymentservice/order/%s", getServiceInstanceURI("paymentservice"), orderId);
		ResponseEntity<Payment> restExchange = restTemplate.exchange(uri, HttpMethod.GET, null, Payment.class, orderId);
		return restExchange.getBody();
	}

	private String getServiceInstanceURI(String serviceName) {
		List<ServiceInstance> instances = discoveryClient.getInstances(serviceName);
		if (instances.size() == 0) {
			throw new RuntimeException();
		} else {
			return instances.get(0).getUri().toString();
		}
	}

}
