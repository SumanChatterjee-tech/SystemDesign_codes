package com.home.InventoryManagementSystem;

import java.util.List;

public class NearestWarehouseStrategy implements WarehouseSelectionStrategy{

	@Override
	public Warehouse selectWarehouse(List<Warehouse> warehouse) {
		// TODO Auto-generated method stub
		return warehouse.get(0); //assuming the first one is the nearest
	}

}
