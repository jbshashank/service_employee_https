package com.ayushya.spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ayushya.spring.bean.BusinessClient;

public interface BusinessClientRepository extends MongoRepository<BusinessClient, String>
{
  // @Query("{'id': ?0}")
  // List<BusinessClient> findByClientId(final int id);
}
