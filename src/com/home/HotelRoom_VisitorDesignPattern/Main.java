package com.home.HotelRoom_VisitorDesignPattern;

public class Main {

	public static void main(String[] args) {
		RoomElement singleRoom = new SingleRoom();
		RoomElement doubleRoom = new DoubleRoom();
		RoomElement dealuxRoom = new DealuxRoom();

		RoomPricingVisitor rp = new RoomPricingVisitor();
		RoomMaintainanceVisitor rm = new RoomMaintainanceVisitor();
		
		singleRoom.accept(rp);
		singleRoom.accept(rm);
	}

}
