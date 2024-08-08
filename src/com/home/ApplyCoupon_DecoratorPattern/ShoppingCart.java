package com.home.ApplyCoupon_DecoratorPattern;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

	List<Product> productList;

	public ShoppingCart() {
		super();
		this.productList = new ArrayList<>();
	}
	
	public void addToCart(Product prodcut) {
		Product productWithEigibleDiscount = new BasedOnTypeCouponDecorator(new PercentageCouponDecorator(prodcut, 20), 20);
		this.productList.add(productWithEigibleDiscount);
	}
	
	public double getTotalPriceOfShoppingcart() {
		double total = 0;
		for(Product p: productList) {
			total+= p.getPrice();
		}
		return total;
	}
}
