package com.example.orderservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.orderservice.entity.OrderLine;

public interface OrderLineRepository extends JpaRepository<OrderLine, Integer> {

	public List<OrderLine> findByOrder(int order);

}