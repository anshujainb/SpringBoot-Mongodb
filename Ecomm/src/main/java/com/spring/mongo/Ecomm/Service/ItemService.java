package com.spring.mongo.Ecomm.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mongo.Ecomm.model.Item;
import com.spring.mongo.Ecomm.repository.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
	ItemRepository itemRepository;
	
	@SuppressWarnings("finally")
	 private Item findOne(String Id) {

	 Item instance = null;
	  try {
	   List < Item > itemList = itemRepository.findAll();
	   for (Item item: itemList) {
	    if (item.getId().equals(Id)) {
	     instance = item;
	     break;
	    }
	   }
	  } catch(Exception e) {
	   e.printStackTrace();
	  } finally {
	   return instance;
	  }
	 }
	
	
	 public List < Item > listItems() {
	  return itemRepository.findAll();
	 }
	
	 public Item createItem(Item item) {
	  return itemRepository.save(item);
	 }
	 
	 
	 public Item updateItem(String id, Item item) {
	  Item updateInstance = this.findOne(id);
	  updateInstance.setName(item.getName());
	  return itemRepository.save(updateInstance);

	}
	 
	
	 public Item deleteItem(String id) {
	 Item instance = findOne(id);
	  itemRepository.delete(instance);
	  return instance;

	}

	
	 public Item getItem(String id) {

	//return userRepository.findById(id).get();
	  return this.findOne(id);
	 }

}
