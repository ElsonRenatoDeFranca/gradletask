package com.example.gradletask;

import com.example.gradletask.domain.Person;
import com.example.gradletask.service.PersonService;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClients;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Getter
@Setter
public class GradletaskApplication implements ApplicationRunner {

	private String urlConnection = "";
	private final PersonService personService;

	public GradletaskApplication(PersonService personService) {
		this.personService = personService;
	}

	public static void main(String[] args) {
		SpringApplication.run(GradletaskApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args)  {
      	args.getNonOptionArgs().stream().forEach(this::setUrlConnection);
        connectToDatabase(this.urlConnection);
		Person person = new Person("Thomas", "Jefferson");
		personService.save(person);
		searchAll();
		deleteAll();
	}

	private void connectToDatabase(String databaseUrl){
        ConnectionString connectionString = new ConnectionString(databaseUrl);
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        MongoClients.create(mongoClientSettings);
    }

	private void searchAll(){
		personService.findAll().stream().forEach(System.out::println);
	}

	private void deleteAll(){ personService.deleteAll(); }

}