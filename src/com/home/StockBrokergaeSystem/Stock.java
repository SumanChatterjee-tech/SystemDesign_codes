package com.home.StockBrokergaeSystem;

import java.util.ArrayList;
import java.util.List;

public class Stock {

	String name;
	double price;
	List<StockObserver> stockObservers = new ArrayList<>();

	public Stock(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
		notifyObservers();
	}

	public void addObserver(StockObserver observer) {
		stockObservers.add(observer);
	}

	public void removeObserver(StockObserver observer) {
		stockObservers.remove(observer);
	}

	public void notifyObservers() {
		for (StockObserver stobs : stockObservers) {
			stobs.update(this);
		}
	}

}
