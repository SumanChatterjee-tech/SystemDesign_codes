package com.home.VendingMachine;

import java.util.List;


public class DispenseState implements State {

	DispenseState(VendingMachine machine, int codeNumber) {

		System.out.println("Currently Vending machine is in DispenseState");
		dispenseProduct(machine, codeNumber);
	}

	@Override
	public void clickOnInsertCoinButton(VendingMachine driverClass) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertCoin(VendingMachine driverClass, Coin coin) {
		// TODO Auto-generated method stub

	}

	@Override
	public void clickOnSelectProductButton(VendingMachine driverClass) {
		// TODO Auto-generated method stub

	}

	@Override
	public void chooseProduct(VendingMachine driverClass, int code) {
		// TODO Auto-generated method stub

	}

	@Override
	public Item dispenseProduct(VendingMachine machine, int codeNumber) {
		System.out.println("Product has been dispensed");
        Item item = machine.getInventory().getItem(codeNumber);
        //machine.getInventory().updateSoldOutItem(codeNumber);
        machine.setVendingMachineState(new IdleState(machine));
        return item;
	}

	@Override
	public List<Coin> refundFullMoney(VendingMachine driverClass) {
		// TODO Auto-generated method stub
		return null;
	}

}
