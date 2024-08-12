package com.home.HotelRoom_VisitorDesignPattern;

public interface RoomElement {
	void accept(RoomVisitor visitor);
}
