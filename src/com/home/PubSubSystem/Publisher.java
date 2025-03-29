package com.home.PubSubSystem;

public interface Publisher {
	
	void publish(Topic topic, Message message);
	void registerTopic(Topic topic);
	void removeTopic(Topic topic);
}
