package com.shopping.service.SalesOrderService;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CustomerSOS {

	@Id
	@Column(name= "cust_id")
	public Long custID;
	@Column(name= "cust_first_name")
	public String firstName;
	@Column(name= "cust_last_name")
	public String lastName;
	@Column(name= "cust_email")
	public String email;
	
	public CustomerSOS() {}
	
	public CustomerSOS(Long custID, String firstName, String lastName, String email) {
		super();
		this.custID = custID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Long getCustID() {
		return custID;
	}

	public void setCustID(Long custID) {
		this.custID = custID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
