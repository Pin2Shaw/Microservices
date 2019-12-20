package com.shopping.services.ItemService;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@EnableHystrix
public class ItemController {
	
	@Autowired
	ItemRepositry itemRepositry;
	
	@Autowired
	ItemConfiguration itemConfiguration;
	
	@GetMapping("/Service2/items")
	public List<Item> getItems() {		
		List<Item>  items= itemRepositry.findAll();
		return items;
	}
	
	@GetMapping("/Service2/items/{itemname}")
	@HystrixCommand(fallbackMethod="alternateMethod")
	public Item getItemByName(@PathVariable String itemname) {		
		
		if(itemname.equals("")) {
			throw new RuntimeException("wrong item name!");
		}
		
		System.out.println("itemName = "+itemname);
		Item item= itemRepositry.findItemByName(itemname);
		return item;
	}
	
	public Item alternateMethod(@PathVariable String itemName) {
		System.out.println("fall back method");
		return new Item(0L,itemConfiguration.getDefaultItemName(),itemConfiguration.getDefaultItemName(),0F);
	}
}
