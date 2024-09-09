package com.home.OvserverDesignPattern;

public class PhoneDisplay implements Observer {

	@Override
	public void update(String updatedVal) {
		System.out.println("Displaying message -"+ updatedVal);
		
	}

}
