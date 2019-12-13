package com.shopping.services.CustomerServices;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
	
	@Id
	//@GeneratedValue
	@Column(name = "Cust_Id")
	public Long id;
	
	@Column(name = "Cust_Email")
	public String email;
	@Column(name = "Cust_Firstname")
	public String firstName;
	@Column(name = "Cust_Lastname")
	public String lastName;
	
	public Customer() {
		
	}
	
	public Customer(Long id, String email, String firstName, String lastName) {
		super();
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
	
	

}
