package com.home.AirlineBookingSystem;

import java.util.ArrayList;
import java.util.List;

public class PersonController {

	List<Person> lisOfPerson;

	public PersonController() {
		this.lisOfPerson = new ArrayList<>();
	}
	
	public void addPerson(Person p) {
		//can check for duplicate and other things
		this.lisOfPerson.add(p);
	}
}
