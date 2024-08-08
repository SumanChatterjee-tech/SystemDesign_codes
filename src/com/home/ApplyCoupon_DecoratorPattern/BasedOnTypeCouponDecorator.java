package com.home.ApplyCoupon_DecoratorPattern;

import java.util.*;

public class BasedOnTypeCouponDecorator extends CouponDecorator{

	Product prodcut;
	int discountedPrice;
	ProductType type;
	static List<ProductType> allowedType = new ArrayList<>();
	static {
		allowedType.add(ProductType.ELECTRONICS);
	}
	public BasedOnTypeCouponDecorator(Product prodcut, int discountedPrice) {
		super();
		this.prodcut = prodcut;
		this.discountedPrice = discountedPrice;
	}

	@Override
	public double getPrice() {
		if(allowedType.contains(type)) {
			double originalPrice  = prodcut.getPrice();
			return originalPrice - 100;
		}
		return prodcut.getPrice();
	}

}
