package com.home.ApplyCoupon_DecoratorPattern;

public class Main {

	public static void main(String[] args) {
		Product p1 = new Item1("Sofa", 10000, ProductType.FURNITURE);
		Product p2 = new Item1("FAN", 10000, ProductType.ELECTRONICS);
		
		ShoppingCart sc = new ShoppingCart();
		sc.addToCart(p1);
		sc.addToCart(p2);
		
		System.out.println(sc.getTotalPriceOfShoppingcart());
	}

}
