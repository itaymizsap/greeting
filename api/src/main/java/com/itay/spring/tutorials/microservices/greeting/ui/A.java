package com.itay.spring.tutorials.microservices.greeting.ui;

public class A {
    public static void main(String[] args) {
        A a = new B();
        B b = new B();
        B c = new C();
        c.f(c);
    }

    public boolean f(A a) {
        System.out.println("A::f");
        System.out.println("Concrete class " + getClassName());
        System.out.println("Param class type " + a.getClassName());
        return true;
    }

    protected String getClassName() {
        return "A";
    }
}