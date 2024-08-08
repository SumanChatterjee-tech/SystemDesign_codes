package com.home.ApplyCoupon_DecoratorPattern;

public abstract class Product {

	String name;
	double originalPrice;
	ProductType type;
	
	Product(){}

	public Product(String name, double originalPrice, ProductType type) {
		super();
		this.name = name;
		this.originalPrice = originalPrice;
		this.type = type;
	}
	
	public abstract double getPrice();
	
	public ProductType getType() {
		return this.type;
	}
}
