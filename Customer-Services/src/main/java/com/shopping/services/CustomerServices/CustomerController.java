package com.shopping.services.CustomerServices;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Configuration
@RestController
@Component
@EnableHystrix
public class CustomerController {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
    private RabbitTemplate rabbitTemplate;
	
	private static final String exchange = "customer_exchange";
	private static final String routingKey = "customer.created";
	
		
	@GetMapping("service1/customers")
	public List<Customer> getCustomerDetails() {
		
		List<Customer> customers = customerRepository.findAll();
		
		return customers;
	}
	
	@PostMapping("/service1/customer")
	@HystrixCommand(fallbackMethod="invalidCustomer")
	public void createCustomer(@RequestBody Customer customer) {
		if(customer == null || customer.getId() == null || customer.getId() == 0
				|| customer.getFirstName() == null || customer.getFirstName() == "") {
			throw new RuntimeException("Bad customer data!");
		} else {
			customerRepository.save(customer);
			rabbitTemplate.convertAndSend(exchange, routingKey, customer);
		  	System.out.println("Customer created... Event Published");
		}		  
	  	
	}
	public void invalidCustomer(Customer customer) {
			System.out.println("Invoked Fallback. Customer Creation Failed!");
	  }
	
	@PostMapping("service1/customer/{id}/{email}/{firstName}/{lastName}")
	public String createCustomer(@PathVariable Long  id,@PathVariable String  email,
			@PathVariable String firstName, @PathVariable String lastName) {
		Customer customer = new Customer(id,email,firstName,lastName);
		//Customer customer =  new Customer(email,firstName,lastName);
		customerRepository.save(customer);
		rabbitTemplate.convertAndSend(exchange,routingKey,"CustomerCreated");
		System.out.println("---------->>>>>>>>");
		return "CustomerCreated";
	}
	
	
}
