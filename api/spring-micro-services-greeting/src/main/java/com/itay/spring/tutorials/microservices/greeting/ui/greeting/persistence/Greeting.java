package com.itay.spring.tutorials.microservices.greeting.ui.greeting.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Greeting {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;
    
    @Column(name="text")
    private String text;
    
    //required because of presence of another non-default CTOR, which takes parameters
    public Greeting() {}
    
    public void setText(String msg) {
        this.text = msg;
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