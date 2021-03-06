package edu.fiap.microservices.observability.controller;

import java.net.URI;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import edu.fiap.microservices.observability.model.Item;
import edu.fiap.microservices.observability.model.Order;
import edu.fiap.microservices.observability.model.PaymentMethod;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	private final RestTemplate restTemplate;

	@Autowired
	OrderController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	@RequestMapping(value = "/{id}/status", method = RequestMethod.GET)
	public ResponseEntity<?> checkOrderStatus(@PathVariable("id") String orderId) {
		logger.info("checking order status of:" + orderId);
		return ResponseEntity.ok("{'status' : 'shipped'}");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getOrder(@PathVariable("id") String orderId) {
		logger.info("retrieving order:" + orderId);
		Item book1 = new Item("101", 1);
		Item book2 = new Item("103", 5);
		PaymentMethod myvisa = new PaymentMethod("VISA", "01/22", "John Doe", "201, 1st Street, San Jose, CA");
		Order order = new Order("101021", orderId, myvisa, new Item[] { book1, book2 },
				"201, 1st Street, San Jose, CA");
		return ResponseEntity.ok(order);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createOrder(@RequestBody Order order) {
		if (order != null) {
			order.setOrderId(UUID.randomUUID().toString());

			//RestTemplate restTemplate = new RestTemplate();
			URI uri = URI.create("http://localhost:10000/inventory");
			restTemplate.put(uri, order.getItems());

			logger.info("creating order :" + order.getOrderId());
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(order.getOrderId()).toUri();

			return ResponseEntity.created(location).build();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
}
