package com.ayushya.spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ayushya.spring.bean.States;

public interface StateRepository extends MongoRepository<States, String> {

}
