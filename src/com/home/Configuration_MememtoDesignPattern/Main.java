package com.home.Configuration_MememtoDesignPattern;

public class Main {

	public static void main(String[] args) {
		ConfigurationOriginator conOrigin = new ConfigurationOriginator(3, 4);
		ConfigurationMememto configMem = conOrigin.createMememto();
		
		Caretaker care = new Caretaker();
		care.addMememto(configMem);
	}

}
