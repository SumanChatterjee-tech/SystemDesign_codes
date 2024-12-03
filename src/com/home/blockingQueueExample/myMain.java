package com.home.blockingQueueExample;

public class myMain {

	public static void main(String[] args) throws InterruptedException {
		UsingPreDefinedBlockingQueue ubq = new UsingPreDefinedBlockingQueue();
		Items it1 = new Items("Suman");
		Items it2 = new Items("Suman1");
		new Thread(new Producer(ubq,it1)).start();
		new Thread(new Producer(ubq,it2)).start();
		Thread.sleep(2000);
		ubq.show();
		new Thread(new Consumer(ubq)).start();
		new Thread(new Consumer(ubq)).start();
		Thread.sleep(2000);
		ubq.show();

	}

}
