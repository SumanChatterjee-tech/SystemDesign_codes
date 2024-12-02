package com.home.LoadBalancer_PlanFulFailedInterview;

import java.util.List;
import java.util.Random;

public class LoadBalancer {

	List<Server> servers;
	Random random;
	int lastServerIndex;

	public LoadBalancer(List<Server> servers) {
		super();
		this.servers = servers;
		this.random = new Random();
		this.lastServerIndex = -1;
	}

	public Server getNextServer() {
		int serverIndex;
		int attempts = 0;

		// Iterate to find an available server that isn't the last used one
		do {
			serverIndex = random.nextInt(servers.size());
			attempts++;
		} while ((serverIndex == lastServerIndex || !servers.get(serverIndex).isAvailable)
				&& attempts < servers.size());

		lastServerIndex = serverIndex;
		return servers.get(serverIndex);
	}

	public void assignTask(Task task) {
		Server server = getNextServer();
		System.out.println("Got free server "+ server.name);
		server.assignTask(task);
	}
}
