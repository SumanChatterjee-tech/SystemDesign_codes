package com.home.PubSubSystem_Advanced;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		 MessageBroker broker = new MessageBroker();

	        // Create topic with 3 partitions
	        broker.createTopic("TechNews", 3);

	        // Create subscribers
	        Subscriber sub1 = new Subscriber("Alice");
	        Subscriber sub2 = new Subscriber("Bob");

	        // Subscribe to the topic
	        broker.subscribe("TechNews", sub1);
	        broker.subscribe("TechNews", sub2);

	        // Publish multiple messages asynchronously
	        for (int i = 1; i <= 10; i++) {
	            broker.publish("TechNews", "Breaking News #" + i);
	        }

	        // Allow some time for messages to be processed
	        Thread.sleep(3000);
	    }

	}
