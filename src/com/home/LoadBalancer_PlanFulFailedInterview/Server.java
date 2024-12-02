package com.home.LoadBalancer_PlanFulFailedInterview;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Server {

	String name;
	boolean isAvailable;
	
	public Server(String name) {
		super();
		this.name = name;
		this.isAvailable = true;
	}
	
	public void assignTask(Task task) {
		this.isAvailable = false;
		ExecutorService ex = Executors.newFixedThreadPool(2);
		Future f = ex.submit(task);
		try {
			String s = (String) f.get();
			if(s.equalsIgnoreCase("DONE")) {
				this.isAvailable = true;
			}
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
