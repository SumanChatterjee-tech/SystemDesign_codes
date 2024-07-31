package com.home.FlyWeightDesignPattern.Solution;

import java.util.*;

public class RobotFactory {

	private static Map<String , IRobot> cache = new HashMap<>();
	

    public static IRobot createRobot(String robotType){

        if(cache.containsKey(robotType)){
            return cache.get(robotType);
        }
        else {
            if(robotType == "HUMANOID"){
                Sprites humanoidSprite = new Sprites();
                IRobot humanoidObject = new HumanRobot(robotType, humanoidSprite);
                cache.put(robotType, humanoidObject);
                return humanoidObject;
            }
            else if(robotType == "ANOTHERROBOT"){
                Sprites AnotherRobotSprite = new Sprites();
                IRobot roboticDogObject = new AnotherRobot(robotType, AnotherRobotSprite);
                cache.put(robotType, roboticDogObject);
                return roboticDogObject;
            }
        }
        return null;
    }
}
