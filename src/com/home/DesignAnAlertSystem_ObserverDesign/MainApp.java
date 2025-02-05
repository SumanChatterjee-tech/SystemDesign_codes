package com.home.DesignAnAlertSystem_ObserverDesign;

public class MainApp {

	public static void main(String[] args) {

		AlertManager manager = new AlertManager();

		// Create subscribers
		User user1 = new User("Alice");
		User user2 = new User("Bob");
		Admin admin = new Admin("System Admin");

		// Register subscribers
		manager.register(user1);
		manager.register(user2);
		manager.register(admin);

		// Create alerts
		Alert emailAlert = new EmailAlert("Server down!", AlertType.CRITICAL, "admin@example.com");
		Alert smsAlert = new SMSAlert("Low disk space!", AlertType.WARNING, "+123456789");
		
		manager.notifySubscribers(smsAlert);
		manager.notifySubscribers(emailAlert);
	}
}
