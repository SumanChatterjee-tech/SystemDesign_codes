package com.home.VendingMachine;

import java.util.List;


public interface State {
	public void clickOnInsertCoinButton(VendingMachine driverClass); //idle State
	
	public void insertCoin(VendingMachine driverClass,  Coin coin); //hasmoney state
	public void clickOnSelectProductButton(VendingMachine driverClass);//hasmoney state
	
	public void chooseProduct(VendingMachine driverClass, int code);//selection state
	
	public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception; //dispence product

	public List<Coin> refundFullMoney(VendingMachine driverClass); //hasmoney, selection(either user press cancel button or
	//lack of funds in acc)
}
