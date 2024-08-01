package com.home.CommandDesignPattern;

public class TurnACOffCommand implements ICommand {

	AirConditionar_Reciver ac;
	
	public TurnACOffCommand(AirConditionar_Reciver ac) {
		super();
		this.ac = ac;
	}
	
	@Override
	public void execute() {
		this.ac.turnOffAc();
	}

	@Override
	public void undo() {
		this.ac.turnOnAc();
	}

}
