package com.home.ElevatorDesignAdvanced;

public class MovingUpState implements ElevatorState{

	@Override
	public void move(Elevator elevator) {
		if(elevator.getUpReuest().isEmpty()) {
			elevator.setState(new IdleState());
			return;
		}
		int nextFloor = elevator.getUpReuest().first();
		elevator.setCurrentFloor(elevator.getCurrentFloor()+1);
		if(nextFloor == elevator.getCurrentFloor()) {
			elevator.getUpReuest().pollFirst();
		}
		
	 if (elevator.getUpReuest().isEmpty()) {
            elevator.setState(new IdleState());
     }
	
	}

	@Override
	public void addRequest(Elevator elevator, Request request) {
		 // Internal requests always get added to the appropriate queue
        if (request.getSource() == RequestSource.INTERNAL) {
            if (request.getTargetFloor() > elevator.getCurrentFloor()) {
                elevator.getUpReuest().add(request.getTargetFloor());
            } else {
                elevator.getDownRequest().add(request.getTargetFloor());
            }
            return;
        }

        // External requests
        if (request.getDirection() == Direction.UP && request.getTargetFloor() >= elevator.getCurrentFloor()) {
            elevator.getUpReuest().add(request.getTargetFloor());
        } else if (request.getDirection() == Direction.DOWN) {
            elevator.getDownRequest().add(request.getTargetFloor());
        }
		
	}

	@Override
	public Direction getDirection() {
		// TODO Auto-generated method stub
		return Direction.UP;
	}

}
