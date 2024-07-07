package com.home.VendingMachine;

public class Main {
	 private static void fillUpInventory(VendingMachine vendingMachine){
		 Inventory inventory = vendingMachine.getInventory();
		 ItemShelf[] itemShelf = inventory.itemShelf;
		 for(int i=0;i<itemShelf.length;i++) {
			 Item newItem = new Item();
			 if(i >=0 && i<3) {
	                newItem.setItemType(ItemType.COKE);
	                newItem.setPrice(12);
	            }else if(i >=3 && i<5){
	                newItem.setItemType(ItemType.PEPSI);
	                newItem.setPrice(9);
	            }
			 itemShelf[i].setItems(newItem);
			 itemShelf[i].setSoldOut(false);
		 }
	 }
	 private static void displayInventory(VendingMachine vendingMachine){

	        ItemShelf[] slots = vendingMachine.getInventory().itemShelf;
	        for (int i = 0; i < slots.length; i++) {

	            System.out.println("CodeNumber: " + slots[i].getCode() +
	                    " Item: " + slots[i].getItems().getItemType() +
	                    " Price: " + slots[i].getItems().getPrice() +
	                    " isAvailable: " + !slots[i].isSoldOut());
	        }
	    }
	public static void main(String[] args) {
		VendingMachine v = new VendingMachine();
		fillUpInventory(v);
		displayInventory(v);
		
		
		 System.out.println("|");
         System.out.println("clicking on InsertCoinButton");
         System.out.println("|");
         
         State vendingState = v.getVendingMachineState();
         vendingState.clickOnInsertCoinButton(v);

         vendingState = v.getVendingMachineState();
         vendingState.insertCoin(v, Coin.ELEVENRUPEE);
         vendingState.insertCoin(v, Coin.TENRUPEE);
        // vendingState.insertCoin(vendingMachine, Coin.NICKEL);
         vendingState.clickOnSelectProductButton(v);

         System.out.println("|");
         System.out.println("clicking on ProductSelectionButton");
         System.out.println("|");

         vendingState = v.getVendingMachineState();
         vendingState.chooseProduct(v, 102);

         displayInventory(v);
	}
	
}
