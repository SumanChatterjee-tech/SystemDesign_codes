package com.home.cCassCastExceptionExample;

import java.util.concurrent.Semaphore;

class A{
	
	void m1() {
		System.out.println("Hello");
	}
}
class B extends A{
	@Override
	void m1() {
		System.out.println("Hi");
	}
}
class C extends B{
	@Override
	void m1() {
		System.out.println("Hi Hello");
	}
}

public class ClassCastExceptionExample {

	public static void main(String[] args) {

		A a = new A();
		B b = new B();
		C c = new C();
		a.m1();
		b.m1();
		c.m1();
		C c1 = (C) a;
		c1.m1();

	}

}
