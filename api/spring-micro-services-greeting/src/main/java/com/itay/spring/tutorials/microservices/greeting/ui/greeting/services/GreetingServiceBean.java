package com.itay.spring.tutorials.microservices.greeting.ui.greeting.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.itay.spring.tutorials.microservices.greeting.ui.greeting.persistence.Greeting;
import com.itay.spring.tutorials.microservices.greeting.ui.greeting.persistence.GreetingRepository;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class GreetingServiceBean implements IGreetingService {
    
    @Autowired
    private GreetingRepository repository;
    
    public GreetingServiceBean() {
	System.out.println("============> GreetingServiceBean is up...");
    }
    
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    @CachePut(value = "greeting-cache", key = "#result.id")
    @Override
    public Greeting create(Greeting greeting) {
	if (greeting == null) return null;
	
	//Create new Greeting
	if (greeting.getId() == null) {
	    return repository.save(greeting);
	}
	
	return null;
    }
    
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    @CachePut(value = "greeting-cache", key = "#greeting.id")
    @Override
    public Greeting update(Greeting greeting) {
	if (greeting == null) return null;
	
	//Update existing greeting
	if (greeting.getId() != null && repository.exists(greeting.getId())) {
	    repository.save(greeting);
	    addAmazingPostFixToEntry(greeting);
	    return greeting;
	}
	
	return null;
    }
    
    @Transactional(propagation = Propagation.MANDATORY, readOnly = false)
    public void addAmazingPostFixToEntry(Greeting greeting) {
	greeting.setText(greeting.getText() + " Amazing!");
	repository.save(greeting);
	//throw new RuntimeException(); // Should demonstrate a transaction Rollback
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, isolation = Isolation.SERIALIZABLE)
    @CacheEvict(value = "greeting", key = "#id")
    @Override
    public boolean delete(Integer id) {
	// return true if there was actually item to remove, or false if no mapping for given greeting-ID key
	if (repository.exists(id)) {
	    repository.delete(id);
	    if (! repository.exists(id)) {
		return true;
	    } else {
		return false;
	    }
	} else {
	    return false;
	}
    }

    @Cacheable(value = "greeting-cache", key = "#id")
    @Override
    public Greeting findOneFromCache(Integer id) {
	return repository.findOne(id);
    }
    
    @Override
    public Greeting findOne(Integer id) {
	return repository.findOne(id);
    }

    //@Cacheable(value = "greeting-cache", key = "#id")
    @Override
    public Iterable<Greeting> findAll() {
	return repository.findAll();
    }
    
    @CacheEvict(value = "greeting-cache", allEntries = true)
    public void evictCache() {}
}