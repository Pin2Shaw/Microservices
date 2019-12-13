package com.shopping.services.CustomerServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

	@Autowired
	CustomerRepository customerRepository;
	
	@GetMapping("service1/customers")
	public List<Customer> getCustomerDetails() {
		
		List<Customer> customers = customerRepository.findAll();
		
		return customers;
	}/*
	
	@GetMapping("service1/customers/{custId}")
	public Item getItemByName(@PathVariable String custId) {		
		
		Customer customer= customerRepository.findItemByName(custId);
		return item;
	}
	*/
	@PostMapping("service1/customer/{id}/{email}/{firstName}/{lastName}")
	
	public String createCustomer(@PathVariable Long  id,@PathVariable String  email,
			@PathVariable String firstName, @PathVariable String lastName) {
		Customer customer = new Customer(id,email,firstName,lastName);
		//Customer customer =  new Customer(email,firstName,lastName);
		customerRepository.save(customer);		
		return "CustomerCreated";
	}
	
	
}
