package com.home.HotelRoom_VisitorDesignPattern;

public class RoomPricingVisitor implements RoomVisitor {

	@Override
	public void visit(SingleRoom singleRoom) {
		System.out.println("Pricing compute of singleroom");
		singleRoom.roomPrice = 1000;

	}

	@Override
	public void visit(DealuxRoom dealuxroom) {
		System.out.println("Pricing compute of dealuxroom");
		dealuxroom.roomPrice = 2000;
	}

	@Override
	public void visit(DoubleRoom doubleroom) {
		System.out.println("Pricing compute of doubleroom");
		doubleroom.roomPrice = 2000; 	
	}

}
