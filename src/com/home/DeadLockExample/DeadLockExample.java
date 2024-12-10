package com.home.DeadLockExample;

import java.util.concurrent.*;

class A{
	public synchronized void  m1(B b) throws InterruptedException {
		Thread.sleep(5000);
		b.m2();
	}
	
	public synchronized void m2() {
		System.out.println("Suman1");
	}
}

class B{
	public synchronized void  m1(A a) throws InterruptedException {
		Thread.sleep(5000);
		a.m2();
	}
	
	public synchronized void m2() {
		System.out.println("Suman2");
	}
}

class Run implements Runnable{
	private A a;
	private B b;
	
	public Run(A a, B b) {
		super();
		this.a = a;
		this.b = b;
	}

	@Override
	public void run() {
		try {
			a.m1(b);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			b.m1(a);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
public class DeadLockExample {

	public static void main(String[] args) {
		A a =new A();
		B b = new B();
//		Run r = new Run(a,b);
//		Thread t = new Thread(r);
//		t.start();
		
		ExecutorService ex = Executors.newFixedThreadPool(5);
		for(int i=0;i<10;i++) {
			ex.execute(new Run(a,b));
		}
	}

}
