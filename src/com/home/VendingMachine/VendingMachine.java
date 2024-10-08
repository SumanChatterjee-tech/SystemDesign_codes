package com.home.VendingMachine;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
	Inventory inventory;
	State vendingMachineState;
	List<Coin> coinList;

	public VendingMachine() {
		vendingMachineState = new IdleState();
		inventory = new Inventory(10);
		coinList = new ArrayList<>();
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public State getVendingMachineState() {
		return vendingMachineState;
	}

	public void setVendingMachineState(State vendingMachineState) {
		this.vendingMachineState = vendingMachineState;
	}

	public List<Coin> getCoinList() {
		return coinList;
	}

	public void setCoinList(List<Coin> coinList) {
		this.coinList = coinList;
	}
}
