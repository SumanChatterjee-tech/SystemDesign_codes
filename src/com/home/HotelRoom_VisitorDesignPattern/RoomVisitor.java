package com.home.HotelRoom_VisitorDesignPattern;

public interface RoomVisitor {

	 void visit(SingleRoom singleRoom);
	 void visit(DealuxRoom dealuxroom);
	 void visit(DoubleRoom doubleroom);
}
