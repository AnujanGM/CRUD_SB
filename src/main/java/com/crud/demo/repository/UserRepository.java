package com.crud.demo.repository;

import com.crud.demo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository <User, Integer>{

}
