package com.home.ParkingLotDesign;

import java.util.List;

public class TwoWheelerManager extends ParkingSportManager {

	public TwoWheelerManager(List<ParkingSpot> parkingSpot) {
		super(parkingSpot);
		// TODO Auto-generated constructor stub
	}

	@Override
	ParkingSpot findParkingSpace() {
		//for example send null
		return new TwoWheelSpot(6, true, null, 20);
	}

}
