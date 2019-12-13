package com.shopping.service.SalesOrderService;

import javax.persistence.Entity;

@Entity
public class OrderLineItem {
	public Long id;
	public String  itemName;
	public Long itemQuantity;
	public String orderId;
	
	public OrderLineItem() {
		
		
	}
	
	public OrderLineItem(Long id, String itemName, Long itemQuantity, String orderId) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.itemQuantity = itemQuantity;
		this.orderId = orderId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Long getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(Long itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	

}
