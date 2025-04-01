package com.home.PubSubSystem_Advanced;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

import java.util.concurrent.*;

public class Partition {
    private final String partitionId;
    private final BlockingQueue<Message> messageQueue;
    private final ConcurrentLinkedQueue<Subscriber> subscribers;
    private final ExecutorService executorService;

    public Partition(String partitionId) {
        this.partitionId = partitionId;
        this.messageQueue = new LinkedBlockingQueue<>();
        this.subscribers = new ConcurrentLinkedQueue<>();
        
        // Thread pool for async message processing
        this.executorService = Executors.newFixedThreadPool(5);
        
        // Start background worker
        startMessageProcessing();
    }

    public void publish(Message message) {
        messageQueue.offer(message); // Add message to queue
    }

    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    private void startMessageProcessing() {
        executorService.submit(() -> {
            while (true) {  // Continuously process messages
                try {
                    Message message = messageQueue.take(); // Blocking call (waits for messages)
                    notifySubscribers(message);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
    }

    private void notifySubscribers(Message message) {
        for (Subscriber subscriber : subscribers) {
            executorService.submit(() -> subscriber.receive(message));
        }
    }

    public void shutdown() {
        executorService.shutdown();
    }
}
