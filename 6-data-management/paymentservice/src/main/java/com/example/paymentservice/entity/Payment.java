package com.example.paymentservice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_payment")
public class Payment {

	@Id
	private int id;

	private String status;

	@Column(name = "approved_date")
	private Date approvedDate;

	private String comments;

	@Column(name = "order_id")
	private int orderId;

	public Payment() {
		super();
		this.approvedDate = new Date();
		this.comments = "No comments";
	}

	public Payment(String comments) {
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
