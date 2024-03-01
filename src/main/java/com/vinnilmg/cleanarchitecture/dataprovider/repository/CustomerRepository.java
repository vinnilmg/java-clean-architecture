package com.vinnilmg.cleanarchitecture.dataprovider.repository;

import com.vinnilmg.cleanarchitecture.dataprovider.repository.entity.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<CustomerEntity, String> {
}
