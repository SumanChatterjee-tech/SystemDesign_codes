package com.home.CommandDesignPattern;

public class AirConditionar_Reciver {

	boolean isOn;
	int temp;
	
	public void turnOnAc() {
		isOn = true;
		System.out.println("Ac is on");
	}
	
	public void turnOffAc() {
		isOn = false;
		System.out.println("Ac is off");
	}
	
	public void setTemp(int temp) {
		this.temp = temp;
		System.out.println("Temperature is :" + this.temp);
	}
}
