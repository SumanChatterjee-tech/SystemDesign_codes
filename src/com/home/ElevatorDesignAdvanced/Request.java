package com.home.ElevatorDesignAdvanced;

public class Request {

	int targetFloor;
	RequestSource source;
	Direction direction;
	
	public Request(int targetFloor, RequestSource source, Direction direction) {
		super();
		this.targetFloor = targetFloor;
		this.source = source;
		this.direction = direction;
	}
	
	public int getTargetFloor() {
		return targetFloor;
	}
	public void setTargetFloor(int targetFloor) {
		this.targetFloor = targetFloor;
	}
	public RequestSource getSource() {
		return source;
	}
	public void setSource(RequestSource source) {
		this.source = source;
	}
	public Direction getDirection() {
		return direction;
	}
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
}
