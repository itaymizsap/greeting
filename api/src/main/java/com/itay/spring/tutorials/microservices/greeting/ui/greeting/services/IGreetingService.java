package com.itay.spring.tutorials.microservices.greeting.ui.greeting.services;

import com.itay.spring.tutorials.microservices.greeting.ui.greeting.persistence.Greeting;

public interface IGreetingService {

    Greeting create(Greeting greeting);

    Greeting update(Greeting greeting);

    boolean delete(Integer id);

    Greeting findOne(Integer id);

    Iterable<Greeting> findAll();

    Greeting findOneFromCache(Integer id);
}
