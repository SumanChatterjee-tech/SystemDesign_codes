package com.home.ElevatorDesignAdvanced;

public class IdleState implements ElevatorState{

	@Override
	public void move(Elevator elevator) {
		if(!elevator.getUpReuest().isEmpty()) {
			elevator.setState(new MovingUpState());
		}else if(!elevator.getDownRequest().isEmpty()) {
			elevator.setState(new MovingDownSyate());
		}
		//keep in ideal state
	}

	@Override
	public void addRequest(Elevator elevator, Request request) {
		// TODO Auto-generated method stub
		 if (request.getTargetFloor() > elevator.getCurrentFloor()) {
	            elevator.getUpReuest().add(request.getTargetFloor());
	        } else if (request.getTargetFloor() < elevator.getCurrentFloor()) {
	            elevator.getDownRequest().add(request.getTargetFloor());
	        }
	}

	@Override
	public Direction getDirection() {
		// TODO Auto-generated method stub
		return Direction.IDLE;
	}

}
