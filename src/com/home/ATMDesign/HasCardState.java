package com.home.ATMDesign;

public class HasCardState extends ATMState {

	public HasCardState() {
		System.out.println("enter your card pin number");
	}

	@Override
	public void authenticatePin(ATM atm, Card card, int pin) {
		if (Card.PIN_NUMBER == pin) {
			atm.setAtmState(new SelectionState());
		}
	}

	@Override
	public void exit(ATM atm) {
		returnCard();
		atm.setAtmState(new IdleState());
		System.out.println("Exit happens");
	}

	@Override
	public void returnCard() {
		System.out.println("Please collect your card");
	}
}
