package com.home.FlyWeightDesignPattern.problem;

public class Main {

	public static void main(String[] args) {
		int x =0;
		int y=0;
		
		for(int i=0;i< 50000000 ;i++) {
			Sprites humanoidRobotSprites = new Sprites();
			Robot humanRobot = new Robot(x+i, y+i, "Human_Robot", humanoidRobotSprites);
		}
		
		for(int i=0;i< 50000000 ;i++) {
			Sprites AnotherRobotSprites = new Sprites();
			Robot Anotherobot = new Robot(x+i, y+i, "Another_Robot", AnotherRobotSprites);
		}
		
		//So here it takes to much memoery as we assumed Sprites object is kind of an Svg and its
		//a heavy operation to create one.
	}

}
