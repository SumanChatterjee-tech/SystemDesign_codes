package com.home.HotelRoom_VisitorDesignPattern;

public class RoomMaintainanceVisitor implements RoomVisitor {

	@Override
	public void visit(SingleRoom singleRoom) {
		System.out.println("Pricing compute of singleroom to maintain");

	}

	@Override
	public void visit(DealuxRoom dealuxroom) {
		System.out.println("Pricing compute of dealuxroom to maintain");
	}

	@Override
	public void visit(DoubleRoom doubleroom) {
		System.out.println("Pricing compute of doubleroom maintain");
	}

}
