package com.home.ATMDesign;


public class ATMRoom {
	ATM atm;
	User user;

	public static void main(String[] args) {
		ATMRoom atmroom = new ATMRoom();
		atmroom.initialise();
		
		atmroom.atm.printCurrentATMStatus();
		atmroom.atm.getAtmState().insertCard(atmroom.atm, atmroom.user.getCard());
		atmroom.atm.getAtmState().authenticatePin(atmroom.atm, atmroom.user.getCard(), 12345);
		atmroom.atm.getAtmState().selectOperation(atmroom.atm, atmroom.user.getCard(), TransactionType.CASH_WITHDRAWAL);
		atmroom.atm.getAtmState().cashWithdrawal(atmroom.atm, atmroom.user.getCard(), 5000);
		atmroom.atm.printCurrentATMStatus();
	}

	public void initialise() {
		atm = ATM.getATMInstane();
		atm.setAtmBalance(3500, 1, 2, 5);
		this.user = createUser();
	}

	private User createUser() {

		User user = new User();
		user.setCard(createCard());
		return user;
	}

	private Card createCard() {

		Card card = new Card();
		card.setBankAccount(createBankAccount());
		return card;
	}

	private UserBankAccount createBankAccount() {

		UserBankAccount bankAccount = new UserBankAccount();
		bankAccount.balance = 3000;

		return bankAccount;

	}
}
