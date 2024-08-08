package com.home.ApplyCoupon_DecoratorPattern;

public class Item1  extends Product{
	
	Item1(String name, double originalPrice, ProductType type){
		super(name, originalPrice, type);
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return originalPrice;
	}

}
