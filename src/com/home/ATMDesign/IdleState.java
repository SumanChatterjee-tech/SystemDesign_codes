package com.home.ATMDesign;



public class IdleState extends ATMState{

	@Override
	 public void insertCard(ATM atm, Card card) {
	        System.out.println("Card has been instered");
	        atm.setAtmState(new HasCardState());
	 }
}
