package com.itay.spring.tutorials.microservices.greeting.mongodb.repository;

import com.itay.spring.tutorials.microservices.greeting.mongodb.document.Greeting;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingRepository extends MongoRepository<Greeting, Integer> {
}
