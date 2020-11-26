package com.example.gradletask.repository;

import com.example.gradletask.domain.Customer;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    @DeleteQuery
    void deleteCustomerByFirstName(String firstName);
}
