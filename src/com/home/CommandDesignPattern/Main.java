package com.home.CommandDesignPattern;

public class Main {

	public static void main(String[] args) {
		AirConditionar_Reciver ac = new AirConditionar_Reciver();
		MyRemoteControl_Invoker remove_invoker = new MyRemoteControl_Invoker();
		remove_invoker.setCommand(new TurnACOnCommand(ac));
		
		//client only needs to do pressbutton and undo, thats all. No need of remembering all the steps of methods.
		remove_invoker.pressButton();
		remove_invoker.undo();

	}

}
