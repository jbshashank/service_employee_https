package com.ayushya.spring.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ayushya.spring.bean.Brands;
import com.ayushya.spring.bean.Cities;

public interface BrandsRepository extends MongoRepository<Brands, String> {

}
