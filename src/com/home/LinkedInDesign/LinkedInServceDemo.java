package com.home.LinkedInDesign;

import java.sql.Timestamp;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LinkedInServceDemo {

	private final Map<Integer, User> users;
	private final Map<String, JobPosting> jobPostings;
	private Notification notifications;

	public LinkedInServceDemo() {
		users = new ConcurrentHashMap<>();
		jobPostings = new ConcurrentHashMap<>();
		this.notifications = new Notification();
	}

	public void registerUser(User user) {
		users.put(user.getId(), user);
	}

	public User loginUser(String email, String password) {
		for (User user : users.values()) {
			if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}

	public void updateUserProfile(User user) {
		users.put(user.getId(), user);
	}

	public void sendConnectrionRequest(User sender, User reciever) {
		notifications.addObserver(reciever);
		notifications.setMessage("A new Connection received:" + " from: " + sender.name +" to "+ reciever.getName());
		notifications.notifyObserver();
	}

	public void acceptConnectionRequest(User reciever, Connnection Connectionrequest) {
		reciever.getConnection().add(Connectionrequest);
	}

	public void DeniedConnectionRequest(User reciever, Connnection Connectionrequest) {
		notifications.removeObserver(Connectionrequest.getUser());
	}

	public void postJobListing(JobPosting jobPosting) {
		jobPostings.put(jobPosting.getId(), jobPosting);
		notifications.setMessage("A new Job Posted by: " + jobPosting.getUser().getName());
		notifications.notifyObserver(); // send to Jobposter's connections
	}

	public void sendMessage(User sender, User receiver, String content) {
		Message message = new Message("1", content,
				new Timestamp(System.currentTimeMillis()), receiver, sender);
		message.setType(MessageType.RECEIVE);
		receiver.getInboxMessages().add(message);
		message.setType(MessageType.SENT);
		sender.getInboxMessages().add(message);
		notifications.setMessage("A new message from: "+ sender.getName()+ " is :"+ content);
		notifications.notifyObserver();
	}

}
