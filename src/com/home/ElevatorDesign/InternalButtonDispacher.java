package com.home.ElevatorDesign;

import java.util.List;

public class InternalButtonDispacher {
	//someone should give me all list of elevator, may be DB
		List<ElevatorController> list = ElevatorCreator.elevatorControllerList;
		
		public void submitRequest(int elevatorid, int floor) {
			for(ElevatorController elevatorController: list) {
				if(elevatorController.elevatorcar.id == elevatorid) {
					elevatorController.subMitInternalRequest(floor, elevatorController.elevatorcar);
				}
			}
		}
}
