package com.ayushya.spring.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ayushya.spring.bean.Product_subCategory;

public interface Product_subCategoryRepository extends MongoRepository<Product_subCategory, String>
{
  @Query("{'brand_id': ?0, 'product_id': ?1}")
  List<Product_subCategory> findProductSubCategory(int brand_id,
                                                   int prodcut_id);

}
