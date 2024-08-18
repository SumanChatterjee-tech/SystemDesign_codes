package com.home.PaymentGateWay_Design_LLD;

public abstract class Instrument {

	int instrumentID;
	int userID;
	InstrumentType type;
	
	
	public int getInstrumentID() {
		return instrumentID;
	}
	public void setInstrumentID(int instrumentID) {
		this.instrumentID = instrumentID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public InstrumentType getType() {
		return type;
	}
	public void setType(InstrumentType type) {
		this.type = type;
	}
	
	
}
