package com.shopping.services.CustomerServices;

import java.util.List;
import java.util.Queue;

//import org.hibernate.boot.jaxb.spi.Binding;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@RestController
public class CustomerController {

	@Autowired
	CustomerRepository customerRepository;
	private RabbitTemplate  rabbitTemplate;
	
	@Value("${shopping.rabbitmq.routingkey}")
	private String routiingKey;
	
	@Value("${shopping.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${shopping.rabbitmq.queue}")
	private String queueName;
	
	@Bean
	Queue queue(){
		
		return new Queue(queueName);
	}
	
	@Bean
	TopicExchange exchange (){
		return new TopicExchange(exchange);
	}

	@Bean
	Binding binding (Queue queue, TopicExchange exchange){
		return BindingBuilder.bind(queue).to(exchange).with(routingKey);
	} 
	
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
		rabbitTemplate.convertAndSend(exchange,routiingKey,"CustomerCreated");
		System.out.println("---------->>>>>>>>");
		return "CustomerCreated";
	}
	
	
}
