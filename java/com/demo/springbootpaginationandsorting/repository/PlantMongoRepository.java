package com.demo.springbootpaginationandsorting.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.demo.springbootpaginationandsorting.model.PlantCollection;

public interface PlantMongoRepository extends MongoRepository<PlantCollection, String>{

}
