package com.home.PubSubSystem;

import java.util.ArrayList;
import java.util.List;

public class WeatherStationPublish implements Publisher{

	List<Topic> topics;
	
	public WeatherStationPublish() {
		this.topics = new ArrayList<>();
	}

	@Override
	public void publish(Topic topicToMatch, Message message) {
		for(Topic topic : topics) {
			if(topic == topicToMatch) {
				topic.publish(message);
			}
		}
	}

	@Override
	public void registerTopic(Topic topic) {
		this.topics.add(topic);
	}

	@Override
	public void removeTopic(Topic topic) {
		this.topics.remove(topic);
	}

}
