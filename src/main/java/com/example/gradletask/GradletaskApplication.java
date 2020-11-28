package com.example.gradletask;

import com.example.gradletask.config.DatabaseInfo;
import com.example.gradletask.domain.Person;
import com.example.gradletask.service.DatabaseInfoService;
import com.example.gradletask.service.PersonService;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.example.gradletask.repository")
@ComponentScan({ "com.example.gradletask.config","com.example.gradletask.repository", "com.example.gradletask.service",
		 "com.example.gradletask.domain" })
@Getter
@Setter
public class GradletaskApplication implements ApplicationRunner {

	private String urlConnection = "";

	@Autowired
	private PersonService personService;

	public static void main(String[] args) {
		SpringApplication.run(GradletaskApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
      	args.getNonOptionArgs().stream().forEach(this::setUrlConnection);
        System.out.println("zzzzzzzzzzzzzzzzz:................."+urlConnection);
        //ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017/umbler");
        ConnectionString connectionString = new ConnectionString(urlConnection);

        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
				.applyConnectionString(connectionString)
				.build();
        //MongoClients.create(mongoClientSettings);

		Person person = new Person("Dwight", "Eisenhower");
		personService.save(person);

		personService.findAll().stream().forEach(System.out::println);



	}

}