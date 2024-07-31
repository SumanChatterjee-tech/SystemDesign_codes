package com.home.FlyWeightDesignPattern.Solution;

public final class AnotherRobot implements IRobot{

	private final String type;
	private final Sprites body;
	
	public AnotherRobot(String type, Sprites body) {
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
