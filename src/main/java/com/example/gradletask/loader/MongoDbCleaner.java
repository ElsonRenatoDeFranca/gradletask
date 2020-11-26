package com.example.gradletask.loader;

import com.example.gradletask.service.CustomerService;
import com.example.gradletask.service.CustomerServiceImpl;

public class MongoDbCleaner {


    private CustomerService customerService = new CustomerServiceImpl();

    public void cleanUpCollection(){
        customerService.deleteAll();
    }

    public static void main(String[] args) {
        MongoDbCleaner mainClass = new MongoDbCleaner();
        mainClass.cleanUpCollection();
    }
}
