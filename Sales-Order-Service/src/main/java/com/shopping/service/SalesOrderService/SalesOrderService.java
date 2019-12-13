package com.shopping.service.SalesOrderService;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SalesOrderService {
	
	@Id
	@Column(name = "SO_ID")
	public Long id;
	
	@Column(name = "SO_Description")
	public String orderDescription;
	
	@Column(name = "SO_Date")
	public Date orderDate;
	
	@Column(name = "SO_Customer")
	public String custId;
	
	@Column(name = "SO_TotalPrice")
	public float totalPrice;
	
	public SalesOrderService() {
		
	}
	
	public SalesOrderService(Long id, String orderDescription, Date orderDate, String custId, float totalPrice) {
		super();
		this.id = id;
		this.orderDescription = orderDescription;
		this.orderDate = orderDate;
		this.custId = custId;
		this.totalPrice = totalPrice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderDescription() {
		return orderDescription;
	}

	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	

}
