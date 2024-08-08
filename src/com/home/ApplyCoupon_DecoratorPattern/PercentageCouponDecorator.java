package com.home.ApplyCoupon_DecoratorPattern;

public class PercentageCouponDecorator extends CouponDecorator{

	Product prodcut;
	int discountedPrice;
	
	public PercentageCouponDecorator(Product prodcut, int discountedPrice) {
		super();
		this.prodcut = prodcut;
		this.discountedPrice = discountedPrice;
	}

	@Override
	public double getPrice() {
		double originalPrice  = prodcut.getPrice();
		return originalPrice - (originalPrice * discountedPrice) %100;  //some discounted calculation 
	}

}
