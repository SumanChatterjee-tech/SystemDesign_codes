package com.home.LinkedInDesign;

import java.util.ArrayList;
import java.util.List;

public class User implements Observers{
	int id;
	String name;
	String email;
	String password;
	Profile profile;
	List<Connnection> connection;
	List<Message> inboxMessages;
	public User(int id, String name, String email, String password, Profile profile) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.profile = profile;
		this.connection = new ArrayList<>();
		this.inboxMessages = new ArrayList<>();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Profile getProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	public List<Connnection> getConnection() {
		return connection;
	}
	public void setConnection(List<Connnection> connection) {
		this.connection = connection;
	}
	public List<Message> getInboxMessages() {
		return inboxMessages;
	}
	public void setInboxMessages(List<Message> inboxMessages) {
		this.inboxMessages = inboxMessages;
	}
	@Override
	public void getUpdate(String message) {
		System.out.println("New Update: "+ message);
	}
}
