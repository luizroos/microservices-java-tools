package com.example.orderservice.entity;

import java.util.Date;

import com.example.orderservice.utils.RandomUtils;

public class PaymentInfo {

	private int id;
	private String status;
	private Date approvedDate;
	private String comments;

	public PaymentInfo() {
		super();
		this.id = RandomUtils.randomPaymentInfoId();
		this.approvedDate = new Date();
		this.comments = "No comments";
		this.status = RandomUtils.randomPaymentInfoStatus();
	}

	public PaymentInfo(String comments) {
		super();
		this.comments = comments;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
