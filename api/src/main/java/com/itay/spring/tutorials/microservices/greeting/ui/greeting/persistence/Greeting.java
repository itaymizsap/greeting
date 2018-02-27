package com.itay.spring.tutorials.microservices.greeting.ui.greeting.persistence;

import javax.persistence.*;

@Entity
public class Greeting {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "text")
    private String text;

    //required because of presence of another non-default CTOR, which takes parameters
    public Greeting() {
    }

    public String getText() {
        return text;
    }

    public void setText(String msg) {
        this.text = msg;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}