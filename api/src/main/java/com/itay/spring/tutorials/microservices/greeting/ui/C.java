package com.itay.spring.tutorials.microservices.greeting.ui;

public class C extends B {

    public boolean f(C c) {
        System.out.println("C::f");
        System.out.println("Concrete class " + getClassName());
        System.out.println("Param class type " + c.getClassName());
        return true;
    }

    @Override
    protected String getClassName() {
        return "C";
    }
}