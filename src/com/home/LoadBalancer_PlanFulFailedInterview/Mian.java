package com.home.LoadBalancer_PlanFulFailedInterview;

import java.util.ArrayList;
import java.util.List;

public class Mian {

	public static void main(String[] args) {
		 int n=5;
		 List<Server> serverList = new ArrayList<>();
		 
		 for(int i=0;i<n;i++) {
			 serverList.add(new Server("Server"+i));
		 }
		 
		 LoadBalancer lb = new LoadBalancer(serverList);
		 
		 for(int i=0;i<n;i++) {
			 lb.assignTask(new Task());
		 }
	}

}
