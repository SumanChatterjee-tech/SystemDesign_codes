package com.home.VendingMachine;

import java.util.List;

public class HashMoneyState implements State {

	 public HashMoneyState(){
	        System.out.println("Currently Vending machine is in HasMoneyState");
    }
	 
	@Override
	public void clickOnInsertCoinButton(VendingMachine driverClass) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertCoin(VendingMachine driverClass, Coin coin) {
		System.out.println("Accepted the coin");
		driverClass.getCoinList().add(coin);
	}

	@Override
	public void clickOnSelectProductButton(VendingMachine driverClass) {
		System.out.println("Selected Product Button clicked");
		driverClass.setVendingMachineState(new SelectionState());

	}

	@Override
	public void chooseProduct(VendingMachine driverClass, int code) {
		// TODO Auto-generated method stub

	}

	@Override
	public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Coin> refundFullMoney(VendingMachine driverClass) {
		System.out.println("Returned the full amount back in the Coin Dispense Tray");
		driverClass.setVendingMachineState(new IdleState());
		return driverClass.getCoinList();
	}

}
