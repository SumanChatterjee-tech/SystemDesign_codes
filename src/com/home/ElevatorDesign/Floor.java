package com.home.ElevatorDesign;


public class Floor { //will have list of floors each index of list denote the number of the floor, user clkcs on button 
	//by number
	ExternalDispatcher externalDispatcher;

	public Floor() {
		externalDispatcher = new ExternalDispatcher();
	}

	public void pressButton(int floorNumber) {

		externalDispatcher.submitExternalRequest(floorNumber);
	}
}
