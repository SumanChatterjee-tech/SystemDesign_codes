package com.home.LoadBalancer_PlanFulFailedInterview;

import java.util.concurrent.Callable;

public class Task implements Callable {

	@Override
	public Object call() throws Exception {
		System.out.println("Task is executed by "+ Thread.currentThread().getName());
		Thread.sleep(3000);
		return "DONE";
	}

}
