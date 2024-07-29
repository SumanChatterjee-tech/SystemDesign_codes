package com.home.InventoryManagementSystem;

import java.util.Map;

public class Order {

	User user;
	Address deliveryAddress;
	Map<Integer, Integer> productCategoryAndCountMap;
    Warehouse warehouse;
    Invoice invoice;
    Payment payment;
    OrderStatus orderStatus;
    
    public Order(User user, Warehouse warehouse) {
    	this.user = user;
    	this.deliveryAddress = user.address;
    	this.productCategoryAndCountMap = user.getUserCart().getCartItems();
    	this.warehouse = warehouse;
    	this.invoice = new Invoice();
    	invoice.generateInvoice(this);
    }
    
    public void checkout(){

        //1. update inventory
        warehouse.removeItemFromInventory(productCategoryAndCountMap);

        //2. make Payment
        boolean isPaymentSuccess = makePayment(new UPIPayment());

        //3. make cart empty
        if(isPaymentSuccess) {
            user.getUserCart().emptyCart();
        }
        else{
            warehouse.addItemToInventory(productCategoryAndCountMap);
        }

    }

    public boolean makePayment(PaymentStartegy paymentStartegy){
        payment = new Payment(paymentStartegy);
       return payment.makepayment();
    }

    public void generateOrderInvoice(){
        invoice.generateInvoice(this);
    }
}
