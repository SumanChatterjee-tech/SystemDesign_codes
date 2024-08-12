package com.home.HotelRoom_VisitorDesignPattern;

public class DoubleRoom implements RoomElement {

	public int roomPrice = 0;
	
	@Override
	public void accept(RoomVisitor visitor) {
		visitor.visit(this);

	}

}
