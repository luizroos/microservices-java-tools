package com.example.orderservice.vo;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderComposerVO {

	@JsonProperty("id")
	private int id;

	@JsonProperty("total_order")
	private double totalOrder;

	@JsonProperty("status")
	private String status;

	@JsonProperty("payment_id")
	private int paymentId;

	@JsonProperty("payment_status")
	private String paymentStatus;

	@JsonProperty("approved_date")
	private Date approvedDate;

	@JsonProperty("comments")
	private String comments;

	@JsonProperty("order_line_composer")
	private List<OrderLineComposerVO> orderLineComposerVO;

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

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Date getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public List<OrderLineComposerVO> getOrderLineComposerVO() {
		return orderLineComposerVO;
	}

	public void setOrderLineComposerVO(List<OrderLineComposerVO> orderLineComposerVO) {
		this.orderLineComposerVO = orderLineComposerVO;
	}

}
