package com.home.ATMDesign;

public class SelectionState extends ATMState {

	public SelectionState() {
		System.out.println("In selection state");
	}
	
	@Override
	public void selectOperation(ATM atm, Card card, TransactionType txnType) {
		if(txnType.value == 1) {
			atm.setAtmState(new CashWithdrawlState());
		}else {
			System.out.println("As I didnt implement anything else");
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
