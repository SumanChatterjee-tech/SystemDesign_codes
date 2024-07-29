package com.home.InventoryManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class ProductCatagory {

	int productCategoryId;
	String catagoryName;
	List<Product> products = new ArrayList<>();
	int price;
	
	public void addProduct(Product p) {
		this.products.add(p);
	}
	
	//remove product, get product
}
