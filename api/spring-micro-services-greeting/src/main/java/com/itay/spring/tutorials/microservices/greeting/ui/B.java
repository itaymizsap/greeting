package com.itay.spring.tutorials.spring.microservices;

public class B extends A {

    public boolean f(B b) {
	System.out.println("B::f");
	System.out.println("Concrete class " + getClassName());
	System.out.println("Param class type " + b.getClassName());
	return true;
    }
    
    @Override
    protected String getClassName() {
	return "B";
    }
}