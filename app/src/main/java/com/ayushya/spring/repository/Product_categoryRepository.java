package com.ayushya.spring.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ayushya.spring.bean.Brands;
import com.ayushya.spring.bean.Cities;
import com.ayushya.spring.bean.Product_category;

public interface Product_categoryRepository extends MongoRepository<Product_category, String> {
	@Query("{'brand_id': ?0}")
	List<Product_category> findProducts(int brand_id);

}
