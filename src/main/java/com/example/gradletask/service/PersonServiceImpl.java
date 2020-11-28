package com.example.gradletask.service;

import com.example.gradletask.domain.Person;
import com.example.gradletask.repository.PersonRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> findAll() {
        log.info("Searching in MongoDb \n\n");
        List<Person> people = personRepository.findAll();
        log.info("Search complete");

        return new ArrayList<>(people);
    }

    @Override
    public void deleteAll(){
        log.info("Deleting collections from MongoDb \n\n");
        personRepository.deleteAll();
        log.info("Removal completed \n\n");
    }

    @Override
    public void save(Person person){
        log.info("Saving collections into MongoDb \n\n");
        personRepository.save(person);
        log.info("Saved collections into MongoDb completed \n\n");

    }

}
