package com.ayushya.spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ayushya.spring.bean.Cities;

import java.util.List;

public interface CityRepository extends MongoRepository<Cities, String> {

    @Query("{'stateId': ?0}")
    List<Cities> findByStateId(final int stateId);

}
