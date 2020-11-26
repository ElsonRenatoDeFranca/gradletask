package com.example.gradletask.service;

import com.example.gradletask.repository.CustomerRepository;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void deleteAll() {
        System.out.println("Deleting to MongoDb ...");
        System.out.println("........\n\n");
        System.out.println("In the middle of process..");
        System.out.println("Deleted\n\n");

        MongoOperations mongoOps = new MongoTemplate(MongoClients.create(), "database");

    }

}
