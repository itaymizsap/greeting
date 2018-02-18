package com.itay.spring.tutorials.spring.microservices;

public class A {
    public boolean f(A a) {
	System.out.println("A::f");
	System.out.println("Concrete class " + getClassName());
	System.out.println("Param class type " + a.getClassName());
	return true;
    }
 
    protected String getClassName() {
	return "A";
    }

    public static void main(String[] args) {
	A a = new B();
	B b = new B();
	B c = new C();
	c.f(c);
    }
}