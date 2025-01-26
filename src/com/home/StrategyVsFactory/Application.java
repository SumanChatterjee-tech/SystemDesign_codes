package com.home.StrategyVsFactory;

public class Application {
	SortStrategy sortStrategy;
	StrategyFacotryService strategyFacotryService;
	public Application(SortStrategy sortStrategy) {
		super();
		this.sortStrategy = sortStrategy;
	}
	public Application(StrategyFacotryService strategyFacotryService) {
		this.strategyFacotryService = strategyFacotryService;
	}
	public void runSortingStrategy(int[] arr) {
		sortStrategy.runSortAlgorithm(arr);
	}
	
	//now think the upper code is not there
	public void runSortingStrategyWithFactory(String name) throws Exception {
		SortStrategy sortStrategy =  strategyFacotryService.determineStrategy(name);
		sortStrategy.runSortAlgorithm(null);
	}
	
	public static void main(String[] args) throws Exception {
		//at runtime we are determining to call Merge Sort
		Application ap1 = new Application(new MergeSortStrategy()); //I created the object
		ap1.runSortingStrategy(null);
		
		//we can use factory class also to determine which strategy object to call
		Application ap2 = new Application(new StrategyFacotryService());
		ap2.runSortingStrategyWithFactory("quick"); //I let program to create the object and behave accoridngly
	}

}
