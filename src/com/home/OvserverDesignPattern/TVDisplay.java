package com.home.OvserverDesignPattern;

public class TVDisplay implements Observer{

	@Override
	public void update(String updatedVal) {
		System.out.println("Tv display- "+ updatedVal);
	}

}
