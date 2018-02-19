package com.itay.spring.tutorials.spring.microservices.greeting.services;

import com.itay.spring.tutorials.spring.microservices.greeting.persistence.Greeting;

public interface IGreetingService {
    
    public Greeting create(Greeting greeting);
    public Greeting update(Greeting greeting);
    public boolean delete(Integer id);
    public Greeting findOne(Integer id);
    public Iterable<Greeting> findAll();
    Greeting findOneFromCache(Integer id);
}
