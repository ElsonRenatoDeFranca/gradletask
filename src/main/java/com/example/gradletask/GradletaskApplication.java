package com.example.gradletask;

import com.example.gradletask.domain.Person;
import com.example.gradletask.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.example.gradletask.repository")
@ComponentScan({ "com.example.gradletask.config","com.example.gradletask.repository", "com.example.gradletask.service",
		 "com.example.gradletask.domain" })
public class GradletaskApplication implements ApplicationRunner {

	private final PersonService personService;

	@Autowired
	public GradletaskApplication(PersonService personService) {
		this.personService = personService;
	}

	public static void main(String[] args) {
		SpringApplication.run(GradletaskApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		personService.findAll().stream().forEach(System.out::println);
		Person person = new Person("Dwight","Eisenhower");
		personService.save(person);
	}
}
