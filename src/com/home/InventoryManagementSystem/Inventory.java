package com.home.InventoryManagementSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Inventory {

	List<ProductCatagory> productcategoryList;

	public Inventory() {
		this.productcategoryList = new ArrayList<>();
	}
	
	 //add new category
    public void addCategory(int categoryId, String name, int price){
    	ProductCatagory productCategory = new ProductCatagory();
        productCategory.price = price;
        productCategory.catagoryName = name;
        productCategory.productCategoryId = categoryId;
        productcategoryList.add(productCategory);
    }


    //add product to the particular category
    public void addProduct(Product product, int productCategoryId){

        //take out the respective productCategory Object
    	ProductCatagory categoryObject = null;
        for(ProductCatagory category : productcategoryList)
        {
            if(category.productCategoryId == productCategoryId){
                categoryObject = category;
            }
        }

        if(categoryObject !=null) {
            categoryObject.addProduct(product);
        }
    }

    //remove product from the category
    public void removeItems(Map<Integer, Integer> productCategoryAndCountMap){

        for(Map.Entry<Integer, Integer> entry : productCategoryAndCountMap.entrySet())
        {
        	ProductCatagory category = getProductCategoryFromID(entry.getKey());
             //category.removeProduct(entry.getValue()); //can implement later
        }

    }

    private ProductCatagory getProductCategoryFromID(int productCategoryId){

        for(ProductCatagory productCategory : productcategoryList){

            if(productCategory.productCategoryId == productCategoryId){
                return productCategory;
            }
        }

        return null;
    }
}
