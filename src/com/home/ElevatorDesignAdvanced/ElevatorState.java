package com.home.ElevatorDesignAdvanced;

public interface ElevatorState {

	void move(Elevator elevator);
	void addRequest(Elevator elevator, Request request);
	Direction getDirection();
}
