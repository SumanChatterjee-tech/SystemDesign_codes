package com.home.Uber_Ola_Design_Advance;

import java.util.UUID;

public class Ride {

	private String Id;
	private Driver driver;
	private Passernger passernger;
	private String startLoc;
	private String endLoc;
	private RideStatus status;
	private PaymentStatus paymentStatus;
	private double fare;
	
	public Ride(Driver driver, Passernger passernger, String startLoc, String endLoc) {
		super();
		Id = UUID.randomUUID().toString();
		this.driver = driver;
		this.passernger = passernger;
		this.startLoc = startLoc;
		this.endLoc = endLoc;
		this.status = RideStatus.REQUESTED;
		this.paymentStatus = PaymentStatus.PENDING;
	}
	
	public void complete() {
		if(this.paymentStatus == PaymentStatus.COMPLETED) {
			this.status =  RideStatus.COMPLETED;
		}
	}
	
	public void denied() {
		this.status = RideStatus.CANCELLED;
	}
	
	public void startRide() { //accepted the ride
		this.status = RideStatus.ONGOING;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public Passernger getPassernger() {
		return passernger;
	}

	public void setPassernger(Passernger passernger) {
		this.passernger = passernger;
	}

	public String getStartLoc() {
		return startLoc;
	}

	public void setStartLoc(String startLoc) {
		this.startLoc = startLoc;
	}

	public String getEndLoc() {
		return endLoc;
	}

	public void setEndLoc(String endLoc) {
		this.endLoc = endLoc;
	}

	public RideStatus getStatus() {
		return status;
	}

	public void setStatus(RideStatus status) {
		this.status = status;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}
}
