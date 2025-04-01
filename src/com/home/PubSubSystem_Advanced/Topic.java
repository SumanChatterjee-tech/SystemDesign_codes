package com.home.PubSubSystem_Advanced;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Topic {
	private final String name;
	private final List<Partition> partitions;

	public Topic(String name, int numPartitions) {
		this.name = name;
		this.partitions = new CopyOnWriteArrayList<>();

		for (int i = 0; i < numPartitions; i++) {
			partitions.add(new Partition(name + "-P" + i));
		}
	}

	public void publish(Message message) {
		int partitionIndex = message.getContent().hashCode() % partitions.size();
		partitions.get(Math.abs(partitionIndex)).publish(message);
	}

	public void subscribe(Subscriber subscriber) {
		for (Partition partition : partitions) {
			partition.addSubscriber(subscriber);
		}
	}

	public List<Partition> getPartitions() {
		return partitions;
	}

	public String getName() {
		return name;
	}
}
