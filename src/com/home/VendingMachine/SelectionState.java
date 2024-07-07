package com.home.VendingMachine;

import java.util.List;

public class SelectionState implements State {

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
		System.out.println("let customer choose the product");
		Item item = driverClass.getInventory().getItem(code);
		
		List<Coin> listOfCoin = driverClass.getCoinList();
		int usertaka=0;
		for(Coin c: listOfCoin) {
			usertaka+=c.value;
		}
		
		if(item.getPrice() > usertaka) {
			System.out.println("Insufficiant money provided by user");
			refundFullMoney(driverClass);
			return;
		}else {
			//if user paid extra give change may be
			driverClass.setVendingMachineState(new DispenseState(driverClass, code));
			return;
		}

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
