package com.home.DesignAnAlertSystem_ObserverDesign;

public class Alert {

	String message;
	AlertType type;
	
	public Alert(String message, AlertType type) {
		super();
		this.message = message;
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public AlertType getType() {
		return type;
	}
	
	
}
