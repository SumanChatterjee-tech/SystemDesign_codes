package com.home.DesignAnAlertSystem_ObserverDesign;

public class SMSAlert extends Alert{
	private String recipientEmail;
	
	public SMSAlert(String message, AlertType type, String email) {
		super(message, type);
		this.recipientEmail = email;
		// TODO Auto-generated constructor stub
	}
	
	public String SMSAlertSent() {
		return "SMS alert sent";
	}
}
