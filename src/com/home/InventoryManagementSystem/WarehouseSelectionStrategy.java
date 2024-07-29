package com.home.InventoryManagementSystem;

import java.util.List;

public interface WarehouseSelectionStrategy {

	public Warehouse selectWarehouse(List<Warehouse> warehouse);
}
