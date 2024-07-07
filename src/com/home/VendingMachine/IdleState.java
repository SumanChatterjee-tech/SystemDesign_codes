package com.home.VendingMachine;

import java.util.ArrayList;
import java.util.List;

public class IdleState implements State {

	public IdleState(){
        System.out.println("Currently Vending machine is in IdleState");
    }

    public IdleState(VendingMachine machine){
        System.out.println("Currently Vending machine is in IdleState");
        machine.setCoinList(new ArrayList<>());
    }
    
	@Override
	public void clickOnInsertCoinButton(VendingMachine driverClass) {
		System.out.println("insert coin button pressed");
		driverClass.setVendingMachineState(new HashMoneyState());

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
	public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Coin> refundFullMoney(VendingMachine driverClass) {
		// TODO Auto-generated method stub
		return null;
	}

}
