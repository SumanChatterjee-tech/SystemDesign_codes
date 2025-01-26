package com.home.StrategyVsFactory;

public class StrategyFacotryService {

	public SortStrategy determineStrategy(String name) throws Exception {
		switch(name) {
		case "merge":
			return new MergeSortStrategy();
			
		case "quick":
			return new QuickSortStrategy();
			
		default:
			throw new Exception();
		}
	}
}
