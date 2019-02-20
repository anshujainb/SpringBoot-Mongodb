package com.spring.mongo.Ecomm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mongo.Ecomm.Service.ItemService;
import com.spring.mongo.Ecomm.model.Item;

@RestController
@RequestMapping(path="/item")
public class ItemController {
	
	@Autowired
	ItemService itemService;
	
	@GetMapping(path="/all")
	public List<Item> getItems(){
		return itemService.listItems();
	}
	
	@PostMapping(path="/save")
	public String saveItems(@RequestBody Item item){
		System.out.println("HHHHHHHHH");
		itemService.createItem(item);
		return "saved successfully";
	}
	
	
	@PostMapping(path="/{id}")
	public String deleteItem(@PathVariable String id,@RequestBody Item item) {
		itemService.deleteItem(id);
		return "item deleted";
	}
	
	@PostMapping(path="/update/{id}")
	public String update(@PathVariable String id,@RequestBody Item item) {
		itemService.updateItem(id, item);
		return "updated";
	}
	
	

}
