package com.spring.mongo.Ecomm.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.spring.mongo.Ecomm.model.Item;

@Repository
public interface ItemRepository extends MongoRepository<Item, String> {

}
