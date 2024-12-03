package com.home.blockingQueueExample;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CreateOwnBlockingQueue<E> {
	Queue<E> q =null;
	int size = 10;
	public CreateOwnBlockingQueue(int size) {
		super();
		this.q = new LinkedList<E>();
		this.size = size;
	}

}

class Utility {
	Lock l = new ReentrantLock();
	Condition queEmpty  = l.newCondition();
	Condition queFull  = l.newCondition();
	int max = 10;
	public void add(CreateOwnBlockingQueue<String> c) throws InterruptedException {
		l.lock();
		while(c.q.size() == max) {
			queFull.await();
		}
		c.q.add("Suman");
		queEmpty.signalAll();
		l.unlock();
	}

	public void remove(CreateOwnBlockingQueue<String> c) throws InterruptedException {
		l.lock();
		while(c.q.size() == 0) {
			queEmpty.await();
		}
		c.q.remove("Suman");
		queFull.signalAll();
		l.unlock();
	}
}
