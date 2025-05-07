package com.home.Uber_Ola_Design_Advance;

import java.util.UUID;

public class Passernger {

	private String id;
	private String name;
	private String contact;
	
	public Passernger(String name, String contact) {
		super();
		this.id = UUID.randomUUID().toString();
		this.name = name;
		this.contact = contact;
	}

	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
}
