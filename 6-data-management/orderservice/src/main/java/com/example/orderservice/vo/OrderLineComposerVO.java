package com.example.orderservice.vo;

public class OrderLineComposerVO {

	private int quantity;
	private int productId;
	private double price;
	private String description;

	public OrderLineComposerVO(int quantity, int productId, double price, String description) {
		super();
		this.quantity = quantity;
		this.productId = productId;
		this.price = price;
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
