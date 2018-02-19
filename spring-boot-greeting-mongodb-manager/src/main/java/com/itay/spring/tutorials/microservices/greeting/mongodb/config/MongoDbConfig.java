package com.itay.spring.tutorials.microservices.greeting.mongodb.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.itay.spring.tutorials.microservices.greeting.mongodb.document.Greeting;
import com.itay.spring.tutorials.microservices.greeting.mongodb.repository.GreetingRepository;

@Configuration
@EnableMongoRepositories(basePackageClasses = GreetingRepository.class)
public class MongoDbConfig {

    @Bean
    public CommandLineRunner runSomeMongoDbCommands(GreetingRepository repository) {
	return new CommandLineRunner() {
	    
	    @Override
	    public void run(String... args) throws Exception {
		repository.save(new Greeting(1, "Hello from Mongo DB"));
		repository.save(new Greeting(2, "Bonjour!"));
		
	    }
	};
    }
}
