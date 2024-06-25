package com.home.ParkingLotDesign;

import java.util.List;

public class ParkingManagerFactory {
	ParkingSportManager getParkingSpotManager(VechicleType vehicleType, List<ParkingSpot> spots) {
        if (vehicleType == vehicleType.TWO_WHEEL)
            return new TwoWheelerManager(spots);
        else if (vehicleType == vehicleType.FOUR_WHEEL)
            return new FourWheelerManager(spots);
        else
            return null; // Handle error
    }
}
