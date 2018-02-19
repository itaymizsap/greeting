package com.itay.spring.tutorials.microservices.greeting.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.itay.spring.tutorials.microservices.greeting.mongodb.document.Greeting;

@Repository
public interface GreetingRepository extends MongoRepository<Greeting, Integer> {}
