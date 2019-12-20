package com.shopping.services.ItemService;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix="item-service")
@Component
public class ItemConfiguration {
	
	private String defaultItemName;

	public String getDefaultItemName() {
		return defaultItemName;
	}

	public void setDefaultItemName(String defaultItemName) {
		this.defaultItemName = defaultItemName;
	}
	
	

}
