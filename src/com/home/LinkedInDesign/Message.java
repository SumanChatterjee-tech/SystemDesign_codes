package com.home.LinkedInDesign;

import java.sql.Timestamp;

public class Message {

	String id;
	String content;
	Timestamp connectionDate;
	User receiver;
	User sender;
	MessageType type;
	
	public Message(String id, String content, Timestamp connectionDate, User receiver, User sender) {
		super();
		this.id = id;
		this.content = content;
		this.connectionDate = connectionDate;
		this.receiver = receiver;
		this.sender = sender;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getConnectionDate() {
		return connectionDate;
	}

	public void setConnectionDate(Timestamp connectionDate) {
		this.connectionDate = connectionDate;
	}

	public User getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
	}
}
