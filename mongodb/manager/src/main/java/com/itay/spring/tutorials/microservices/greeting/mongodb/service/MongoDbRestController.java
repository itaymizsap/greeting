package com.itay.spring.tutorials.microservices.greeting.mongodb.service;

import com.itay.spring.tutorials.microservices.greeting.mongodb.document.Greeting;
import com.itay.spring.tutorials.microservices.greeting.mongodb.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class MongoDbRestController {

    @Autowired
    GreetingRepository greetingRepo;

    @GetMapping("/")
    public String landingPage() {
        return "<H1>Hello, This is MongoDB manager service!</H!>";
    }

    @GetMapping("/greeting/")
    public Collection<Greeting> findAll() {
        return greetingRepo.findAll();
    }
}
