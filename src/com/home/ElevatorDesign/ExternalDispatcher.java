package com.home.ElevatorDesign;

import java.util.List;

public class ExternalDispatcher {
	List<ElevatorController> list = ElevatorCreator.elevatorControllerList;
	
	public void submitExternalRequest(int floor) {
		//business logic to decide which lift should serve the request
		//will call subMitExternalequest from elevatorController based on that allotment
	}
}
