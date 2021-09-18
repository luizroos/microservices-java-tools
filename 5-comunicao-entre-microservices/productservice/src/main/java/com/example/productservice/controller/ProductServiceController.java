package com.example.productservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.productservice.entity.Product;

@RestController
@RequestMapping(value = "/v1/productservice")
public class ProductServiceController {

	public ResponseEntity<?> getProduct(@PathVariable(name = "productId") int productId) {
		Product product = null; // Parte 1. item 13.b
		return ResponseEntity.ok(product);
	}

	public ResponseEntity<?> updatePrice(@RequestBody Product product) {
		// Parte 1.  item 13.c
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

}