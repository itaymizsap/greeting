package com.itay.spring.tutorials.spring.microservices.greeting.rest;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itay.spring.tutorials.spring.microservices.greeting.persistence.Greeting;
import com.itay.spring.tutorials.spring.microservices.greeting.services.IGreetingService;

@RestController
public class GreetingController {

    @Autowired
    IGreetingService greetingService;
    
    public GreetingController() {
	System.out.println("============> REST API is up...");
    }  
    
    @GetMapping("/")
    public ResponseEntity<String> landingPage() {
	return new ResponseEntity<String>(
		"<button onclick=\"location.href = '/greetings/';\" id=\"myButton\" class=\"float-left submit-button\">"
		+ "Get some Greetings"
		+ "</button>"
		, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/greetings/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Greeting>> getGreetings() {
	Iterable<Greeting> greetingCollection = greetingService.findAll();
	return new ResponseEntity<Iterable<Greeting>>(greetingCollection,HttpStatus.OK);
    }
    
    @GetMapping(value = "/greetings/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Greeting> getGreetingById(@PathVariable(name = "id") Integer id) {
	Timestamp ts1 = Timestamp.valueOf(LocalDateTime.now());
	Greeting greeting = greetingService.findOne(id);
	Timestamp ts2 = Timestamp.valueOf(LocalDateTime.now());
	System.out.println("---------------------------------------------------------> " + (ts2.getNanos() - ts1.getNanos()));
	return 	new ResponseEntity<Greeting>(greeting, greeting != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
    
    @GetMapping(value = "/greetings/cache/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Greeting> getCachedGreetingById(@PathVariable(name = "id") Integer id) {
	Timestamp ts1 = Timestamp.valueOf(LocalDateTime.now());
	Greeting greeting = greetingService.findOneFromCache(id);
	Timestamp ts2 = Timestamp.valueOf(LocalDateTime.now());
	System.out.println("---------------------------------------------------------> " + (ts2.getNanos() - ts1.getNanos()));
	return 	new ResponseEntity<Greeting>(greeting, greeting != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
    
    //Creating only if not exist
    @PostMapping(value = "/greetings/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Greeting> createGreeting(@RequestBody Greeting newGreeting) {
	Greeting savedGreeting = newGreeting != null && newGreeting.getId() == null ? greetingService.create(newGreeting) : null;
	return new ResponseEntity<Greeting>(savedGreeting, savedGreeting != null ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }
    
    //Updates only if already exists
    @PutMapping(value = "/greetings/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Greeting> updateGreeting(@RequestBody Greeting newGreeting) {
	Greeting savedGreeting = (newGreeting != null && newGreeting.getId() != null) ? greetingService.update(newGreeting) : null;
	return new ResponseEntity<Greeting>(savedGreeting, savedGreeting != null ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    //Delete only if exists for such JSON-ID
    @DeleteMapping(value = "/greetings/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Greeting> deleteGreeting(@RequestBody(required = false) Greeting greetingToDelete) {
	boolean isDeleted = greetingService.delete(greetingToDelete.getId());
	return new ResponseEntity<Greeting>((Greeting)null, isDeleted ? HttpStatus.NO_CONTENT : HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    //Delete only if exists for such PathVariable-ID
    @DeleteMapping(value = "/greetings/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Greeting> deleteGreeting(@PathVariable(name = "id", required = false) Integer id) {
	boolean isDeleted = greetingService.delete(id);
	return new ResponseEntity<Greeting>((Greeting)null , isDeleted ? HttpStatus.NO_CONTENT : HttpStatus.INTERNAL_SERVER_ERROR);
    }
}