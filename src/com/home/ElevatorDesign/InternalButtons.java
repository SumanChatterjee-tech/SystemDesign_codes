package com.home.ElevatorDesign;

import java.util.List;

public class InternalButtons {
	InternalButtonDispacher internalDispatcher = new InternalButtonDispacher();
	
	public void pressButton(ElevatorCar elevatorcar, int floor) {
		internalDispatcher.submitRequest(elevatorcar.id, floor);
		
	}
}
