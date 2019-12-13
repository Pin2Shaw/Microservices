package com.shopping.services.ItemService;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepositry extends JpaRepository<Item, Long> {

	public Item findItemByName(String itemname);
}
