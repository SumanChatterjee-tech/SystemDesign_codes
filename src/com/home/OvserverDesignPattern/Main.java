package com.home.OvserverDesignPattern;

public class Main {

	public static void main(String[] args) {
		WeatherStationObserver wto = new WeatherStationObserver(); //name is incorrect, it has to be WeatherStationSubject
		
		PhoneDisplay ph = new PhoneDisplay();
		TVDisplay tv = new TVDisplay();
		
		wto.addObserver(tv);
		wto.addObserver(ph);
		
		wto.setMessage("Weather will be cloudy");
		
		wto.notifyObserver();

	}

}
