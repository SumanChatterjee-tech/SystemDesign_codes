package com.home.ElevatorDesignAdvanced;

public class MovingDownSyate implements ElevatorState{
	
	@Override
    public void move(Elevator elevator) {
        if (elevator.getDownRequest().isEmpty()) {
            elevator.setState(new IdleState());
            return;
        }

        Integer nextFloor = elevator.getDownRequest().first();
        elevator.setCurrentFloor(elevator.getCurrentFloor() - 1);

        if (elevator.getCurrentFloor() == nextFloor) {
            System.out.println("Elevator " + elevator.id + " stopped at floor " + nextFloor);
            elevator.getDownRequest().pollFirst();
        }

        if (elevator.getDownRequest().isEmpty()) {
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
        if (request.getDirection() == Direction.DOWN && request.getTargetFloor() <= elevator.getCurrentFloor()) {
            elevator.getDownRequest().add(request.getTargetFloor());
        } else if (request.getDirection() == Direction.UP) {
            elevator.getUpReuest().add(request.getTargetFloor());
        }
    }

    @Override
    public Direction getDirection() { return Direction.DOWN; }

}
