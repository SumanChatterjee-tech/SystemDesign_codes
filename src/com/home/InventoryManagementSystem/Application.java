package com.home.InventoryManagementSystem;

import java.util.List;



public class Application {

	UserController userController;
    WarehouseController warehouseController;
    OrderController orderController;
    
    public Application(List<User> userList, List<Warehouse> warehouseList) {
    	 userController = new UserController(userList);
         warehouseController = new WarehouseController(warehouseList , null);
         orderController = new OrderController();
    }
    
    //get user object
    public User getUser(int userId){
        return userController.getUser(userId);
    }

    //get warehouse
    public Warehouse getWarehouse(WarehouseSelectionStrategy warehouseSelectionStrategy){
        return warehouseController.selectWarehosue(warehouseSelectionStrategy);

    }

    //get inventory
    public Inventory getInventory(Warehouse warehouse){
        return warehouse.inventory;

    }

    //add product to cart
    public void addProductToCart(User user, ProductCatagory product, int count){
        Cart cart = user.getUserCart();
        cart.addItemInCart(product.productCategoryId, count);
    }

    //place order
    public Order placeOrder(User user, Warehouse warehouse){
        return orderController.createNewOrder(user, warehouse);
    }

    public void checkout(Order order){
        order.checkout();
    }

}
