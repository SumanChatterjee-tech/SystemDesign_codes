package com.home.ElevatorDesignAdvanced;

import java.util.List;
import java.util.Optional;

public class NearestElevatorStrategy implements ElevatorSelectionStrategy{

	@Override
	public Optional<Elevator> selectElevator(List<Elevator> elevators, Request request) {
		// TODO Auto-generated method stub
		Elevator best = null;
		int minDistance = Integer.MAX_VALUE; 
		for(Elevator elevator : elevators) {
			if(isSuitable(elevator, request)) {
				int distance = Math.abs(elevator.currentFloor - request.getTargetFloor());
				if(distance < minDistance) {
					distance = minDistance;
					best = elevator;
				}
			}
		}
		return Optional.ofNullable(best);
	}
	
	public boolean isSuitable(Elevator elevator, Request req) {
		int currElevFloor = elevator.getCurrentFloor();
		int targetFloor = req.getTargetFloor();
		if(elevator.getDirection() == Direction.IDLE) {
			return true;
		}else {
			if(req.getDirection() == Direction.UP &&  currElevFloor <= targetFloor) {
				return true;
			}else if(req.getDirection() == Direction.UP &&  currElevFloor >= targetFloor) {
				return true;
			}
		}
		return false;
		
	}

}
