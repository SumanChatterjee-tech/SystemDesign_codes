package com.home.RentalCarDesign;

import java.util.Date;

public class Reservation {

    int reservationId;
    User user;
    Vehicle vehicle;
    Date bookingDate;
    Date dateBookedFrom;
    Date dateBookedTo;
    Long fromTimeStamp;
    Long toTimeStamp;
    Location pickUpLocation;
    Location dropLocation;
    ReservationType reservationType;
    ReservationStatus reservationStatus;
    Location location;
    
    public int createReservation(Vehicle v, User u) {
    	   reservationId = 12232;
           this.user=user;
           this.vehicle=vehicle;
           reservationType = ReservationType.DAILY;
           reservationStatus = ReservationStatus.SCHEDULED;
           //CRUD operation
           return reservationId;
    }
    
    //CRUD operations for other operation
    //public void getLocationWisecancelReservation()
    //public void getTotalInprogressReservationLocationWise()
    //public void getLocationWiseScheduledReservation()
}
