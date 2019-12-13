package com.shopping.services.ItemService;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
	
	@Autowired
	ItemRepositry itemRepositry;
	
	@GetMapping("/Service2/items")
	public List<Item> getItems() {		
		List<Item>  items= itemRepositry.findAll();
		return items;
	}
	
	@GetMapping("/Service2/items/{itemname}")
	public Item getItemByName(@PathVariable String itemname) {		
		
		Item item= itemRepositry.findItemByName(itemname);
		return item;
	}

}
