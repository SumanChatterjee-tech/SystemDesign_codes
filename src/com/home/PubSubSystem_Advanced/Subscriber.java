package com.home.PubSubSystem_Advanced;

public class Subscriber {
    private final String id;

    public Subscriber(String id) {
        this.id = id;
    }

    public void receive(Message message) {
        System.out.println(Thread.currentThread().getName() + " - Subscriber " + id + " received: " + message.getContent());
        
        // Simulate message processing delay
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
