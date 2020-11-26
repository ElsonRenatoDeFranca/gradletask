package com.example.gradletask.service;

import com.example.gradletask.domain.Person;

import java.util.List;

public interface PersonService {
    List<Person> findAll();
    void deleteAll();
    void save(Person person);
}
