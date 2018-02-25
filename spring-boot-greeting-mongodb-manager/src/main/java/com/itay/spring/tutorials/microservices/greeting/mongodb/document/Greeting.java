package com.itay.spring.tutorials.microservices.greeting.mongodb.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "greeting")
public class Greeting {

    @Id
    private Integer id;
    private String text;
    
    //required because of presence of another non-default CTOR, which takes parameters
    public Greeting() {}
    
    public Greeting(int id, String greetingMessage) {
	text = greetingMessage;
	this.id = id;
    }

    public void setText(String greetingMessage) {
        this.text = greetingMessage;
    }

    public void setId(Integer id) {
        this.id = id;
    }  
    
    public String getText() {
	return text;
    }
    
    public Integer getId() {
	return id;
    }
}
