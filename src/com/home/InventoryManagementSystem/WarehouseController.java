package com.home.InventoryManagementSystem;

import java.util.List;

public class WarehouseController {

    List<Warehouse> warehouseList;
    WarehouseSelectionStrategy warehouseSelectionStrategy = null;

    WarehouseController(List<Warehouse> warehouseList, WarehouseSelectionStrategy warehouseSelectionStrategy){
        this.warehouseList = warehouseList;
        this.warehouseSelectionStrategy = warehouseSelectionStrategy;
    } 
    
    //add new warehouse
    public void addNewWarehouse(Warehouse warehouse){
        warehouseList.add(warehouse);
    }

    //remove warehouse
    public void removeWarehouse(Warehouse warehouse){
        warehouseList.remove(warehouse);
    }
    
    public Warehouse selectWarehosue(WarehouseSelectionStrategy selectionStrategy) {
    	this.warehouseSelectionStrategy = selectionStrategy;
    	return this.warehouseSelectionStrategy.selectWarehouse(warehouseList);
    }
}
