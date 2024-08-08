package com.home.ApplyCoupon_DecoratorPattern;

public class Item2  extends Product{
	
	Item2(String name, double originalPrice, ProductType type){
		super(name, originalPrice, type);
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return originalPrice;
	}

}
