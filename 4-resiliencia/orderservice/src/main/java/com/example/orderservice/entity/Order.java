package com.example.orderservice.entity;

import com.example.orderservice.utils.RandomUtils;

public class Order {

	private int id;
	private double totalOrder;
	private String status;
	private PaymentInfo paymentInfo;

	public Order(int id) {
		super();
		this.id = id;
		this.totalOrder = RandomUtils.randomTotalOrder();
		this.status = RandomUtils.randomOrderStatus();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTotalOrder() {
		return totalOrder;
	}

	public void setTotalOrder(double totalOrder) {
		this.totalOrder = totalOrder;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public PaymentInfo getPaymentInfo() {
		return paymentInfo;
	}

	public void setPaymentInfo(PaymentInfo paymentInfo) {
		this.paymentInfo = paymentInfo;
	}

}
