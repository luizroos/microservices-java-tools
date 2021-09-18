package com.example.orderservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "tbl_order_line")
public class OrderLine {

	@Id
	@JsonProperty("id")
	private int id;

	@JsonProperty("quantity")
	private int quantity;

	@JsonProperty("product_id")
	@Column(name = "product_id")
	private int productId;

//	@ManyToOne
//	@JoinColumn(name = "order_id", referencedColumnName = "id")
	@JsonProperty("order_id")
	@Column(name = "order_id")
	private int order;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

}
