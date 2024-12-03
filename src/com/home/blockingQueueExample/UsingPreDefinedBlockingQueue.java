package com.home.blockingQueueExample;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Items{
	private String name;

	public Items(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

class Producer implements Runnable{
	
	UsingPreDefinedBlockingQueue ubq;
	Items item;

	public Producer(UsingPreDefinedBlockingQueue ubq, Items item) {
		super();
		this.ubq = ubq;
		this.item = item;
	}
	@Override
	public void run() {
		ubq.CreateItem(item);
		
	}
	
}

class Consumer implements Runnable{
	
	UsingPreDefinedBlockingQueue ubq;

	public Consumer(UsingPreDefinedBlockingQueue ubq) {
		super();
		this.ubq = ubq;
	}
	@Override
	public void run() {
		ubq.removeItem();
		
	}	
}

public class UsingPreDefinedBlockingQueue {
	 BlockingQueue<Items> bq = new ArrayBlockingQueue<Items>(10);
	
	public void CreateItem(Items item) {
		//while(true) {
			bq.add(item);
		//}
	}
	
	public void removeItem() {
		//while(true) {
			bq.remove();
		//}
	}
	
	public void show() {
		System.out.println(bq.size());
	}
}
