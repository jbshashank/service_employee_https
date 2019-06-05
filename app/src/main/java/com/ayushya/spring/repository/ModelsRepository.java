package com.ayushya.spring.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ayushya.spring.bean.Models;

public interface ModelsRepository extends MongoRepository<Models, String>
{

  // @Query("{ $or: [{'brand_id': 1001,'product_id': 10001 }]}")
  @Query("{'brand_id': ?0 , 'product_id': ?1, 'productSubCat_id': ?2 }")
  List<Models> findModels(int brand_id,
                          int product_id,
                          int productSubCat_id);

}
