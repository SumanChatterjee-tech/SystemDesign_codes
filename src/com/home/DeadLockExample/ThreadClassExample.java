package com.home.DeadLockExample;

class A1 implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		for(int i=0;i<1;i++){
			System.out.println("child Thread");
		
	}
  }
}

public class ThreadClassExample {

	public static void main(String[] args) {
		A1 a=new A1();
		Thread t1 = new Thread(a);
		Thread t2 = new Thread();
		t1.start();
		t1.run();
		t2.start();
		t2.run();
		a.run();
		//a.start(); //Compile time error

	}

}
