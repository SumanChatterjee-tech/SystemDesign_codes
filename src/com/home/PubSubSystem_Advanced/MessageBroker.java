package com.home.PubSubSystem_Advanced;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MessageBroker {
    private final Map<String, Topic> topics;

    public MessageBroker() {
        this.topics = new ConcurrentHashMap<>();
    }

    public void createTopic(String topicName, int partitions) {
        topics.putIfAbsent(topicName, new Topic(topicName, partitions));
    }

    public void publish(String topicName, String message) {
        Topic topic = topics.get(topicName);
        if (topic != null) {
            topic.publish(new Message(message));
        } else {
            System.out.println("Topic " + topicName + " does not exist.");
        }
    }

    public void subscribe(String topicName, Subscriber subscriber) {
        Topic topic = topics.get(topicName);
        if (topic != null) {
            topic.subscribe(subscriber);
        } else {
            System.out.println("Topic " + topicName + " does not exist.");
        }
    }
}
