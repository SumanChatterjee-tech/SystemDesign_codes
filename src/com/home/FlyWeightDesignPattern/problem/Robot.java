package com.home.FlyWeightDesignPattern.problem;

public class Robot {

	int coordinatex; //extrinsic data (it changes by client)
	int coordiantey; //extrinsic data (it changes by client)
	String type; //intrinsic data (Remains same even if you create 1cr. objects)
	Sprites body; //intrinsic data (Remains same even if you create 1cr. objects)
	
	public Robot(int coordinatex, int coordiantey, String type, Sprites body) {
		super();
		this.coordinatex = coordinatex;
		this.coordiantey = coordiantey;
		this.type = type;
		this.body = body;
	}
	
	//getters and setters
}
