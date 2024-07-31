package com.home.FlyWeightDesignPattern.Solution;


public class Main {

	public static void main(String[] args) {
		IRobot humanoidRobot1 = RobotFactory.createRobot("HUMANOID");
        humanoidRobot1.display(1,2);


        IRobot humanoidRobot2 = RobotFactory.createRobot("HUMANOID");
        humanoidRobot2.display(10,30);

        IRobot anotherrobot1 = RobotFactory.createRobot("ANOTHERROBOT");
        anotherrobot1.display(2,9);

        IRobot anotherrobot2 = RobotFactory.createRobot("ANOTHERROBOT");
        anotherrobot2.display(11,19);
	}

}
