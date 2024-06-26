package com.home.ElevatorDesign;

import java.util.PriorityQueue;

public class ElevatorController {
	ElevatorCar elevatorcar;
	PriorityQueue<Integer> upMinQueue;
	PriorityQueue<Integer> downMaxQueue;
	
	public ElevatorController(ElevatorCar elevatorcar) {
		super();
		this.elevatorcar = elevatorcar;
		this.upMinQueue = new PriorityQueue<>();
		this.downMaxQueue = new PriorityQueue<>((a, b)-> b-a); //reverse order for down request
	}
	
	public void subMitInternalRequest(int floor, ElevatorCar elevatorCar) {
		
	}
	
	public void subMitExternalequest(int floor, ElevatorCar car) {
		//dedicated car is given now, if car is moving up and user's floor is less than current floor then put to a task queue
		//beacuse right now its not possible to handle this
		
	}
}
