package com.home.FlyWeightDesignPattern.Solution;

public final class HumanRobot implements IRobot{

	private final String type;
	private final Sprites body;
	
	public HumanRobot(String type, Sprites body) {
		super();
		this.type = type;
		this.body = body;
	}
	
	//only getters for immutibality

	@Override
	public void display(int coordinatex, int coordinatey) {
		// TODO Auto-generated method stub
		
	}
}
