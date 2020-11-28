package com.example.gradletask.service;


import org.springframework.stereotype.Service;

@Service
public class DatabaseInfoServiceImpl implements DatabaseInfoService{

    private String connectionDetails = "";

    @Override
    public String getConnectionDetails() {
        return connectionDetails;
    }

    @Override
    public String setConnectionDetails(String connectionDetails) {
        return connectionDetails;
    }
}
