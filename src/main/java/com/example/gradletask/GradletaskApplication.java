package com.example.gradletask;

import com.example.gradletask.config.DatabaseInfo;
import com.example.gradletask.domain.Person;
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
@Configuration
@Getter
@Setter
public class GradletaskApplication implements ApplicationRunner {

	private final PersonService personService;
	private StringBuilder connectionString = new StringBuilder();

	@Autowired
	public GradletaskApplication(PersonService personService) {
		this.personService = personService;
	}

	public static void main(String[] args) {
		SpringApplication.run(GradletaskApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		boolean debug = args.containsOption("debug");
		//List<String> arguments = args.getNonOptionArgs();
		args.getNonOptionArgs().stream().forEach(s -> this.setConnectionString(connectionString.append(s)));
		System.out.println("STR: "+ connectionString.toString());

		//databaseInfo.setConnectionDetails(arguments.get(0));
		//mongodb://localhost:27017/umbler
		System.out.println(debug);
		//System.out.println(arguments);
		//System.out.println(databaseInfo);

		//databaseInfo.setConnectionDetails("mongodb://localhost:27017/umbler");


		personService.findAll().stream().forEach(System.out::println);
		Person person = new Person("Dwight", "Eisenhower");
		//personService.save(person);
		personService.deleteAll();
	}

	@Bean
	public DatabaseInfo databaseInfo() {

		DatabaseInfo databaseInfo = new DatabaseInfo();
		databaseInfo.setConnectionDetails(this.getConnectionString().toString());
		System.out.println(databaseInfo);
		return new DatabaseInfo();
	}
}