package com.home.DesignAnAlertSystem_ObserverDesign;

public class EmailAlert extends Alert{
    private String phoneNumber;
	
	public EmailAlert(String message, AlertType type, String phoneNumber) {
		super(message, type);
		this.phoneNumber = phoneNumber;
		// TODO Auto-generated constructor stub
	}
	
	public String EmailAlertSent() {
		return "Email alert sent";
	}
}
