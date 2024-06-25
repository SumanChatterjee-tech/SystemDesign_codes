package com.home.ParkingLotDesign;

public class Vehicle {
	private long id;
	private VechicleType vt;
	public Vehicle(long id, VechicleType vt) {
		super();
		this.id = id;
		this.vt = vt;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public VechicleType getVt() {
		return vt;
	}
	public void setVt(VechicleType vt) {
		this.vt = vt;
	}
}
