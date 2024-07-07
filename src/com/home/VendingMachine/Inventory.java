package com.home.VendingMachine;


public class Inventory {
	ItemShelf[] itemShelf;

	public Inventory(int sizeOfInventory) {
		itemShelf = new ItemShelf[sizeOfInventory];
		initialEmptyInventory(sizeOfInventory);
	}

	void initialEmptyInventory(int sizeOfInventory) {
		int startCode = 101;
		for (int i = 0; i < itemShelf.length; i++) {
			ItemShelf space = new ItemShelf();
			space.setCode(startCode);
			space.setSoldOut(true);
			itemShelf[i] = space;
			startCode++;
		}
	}
	
	void addProduct(Item item , int codeNumber) {
		for (ItemShelf itemShelf : itemShelf) {
            if (itemShelf.code == codeNumber) {
                if (itemShelf.isSoldOut()) {
                    itemShelf.setItems(item);
                    itemShelf.setSoldOut(false);
                }
            }
        }
	}
	
	  public Item getItem(int codeNumber){

	        for (ItemShelf itemShelf : itemShelf) {
	            if (itemShelf.code == codeNumber) {
	                if (itemShelf.isSoldOut()) {
	                	System.out.println("item already sold out");
	                	return null;
	                } else {

	                    return itemShelf.getItems();
	                }
	            }
	        }
			return null;
	    }
}
