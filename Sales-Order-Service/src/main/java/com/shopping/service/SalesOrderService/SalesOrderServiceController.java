package com.shopping.service.SalesOrderService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SalesOrderServiceController {
	
	
	@Autowired
	//CustomerRepository custSOS;
	SalesOrderServiceRepository SOSRepository;
	CustomerSOSRepository customerSOSRepository;
	
	public void insertCustSOS() {
		new RestTemplate().getForEntity("http://localhost:6071/service1/customers{customerID}", CustomerSOS.class)
		customerSOSRepository.save(CustomerSOS);
		
	}
	
	public void createOrder(@PathVariable String OrderDesc,
			@PathVariable String OrderDate, @PathVariable String customerID,
			@PathVariable List<String> itemNames) {
		//Insert Salesorde and Sales Item
		
	//	new RestTemplate().getForEntity("http://localhost:6071/service1/customers{customerID}", Customer.class)
		
		//SOSRepository
		
		
	}
	
}
