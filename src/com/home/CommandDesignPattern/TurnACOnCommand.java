package com.home.CommandDesignPattern;

public class TurnACOnCommand implements ICommand {

	AirConditionar_Reciver ac;
	
	public TurnACOnCommand(AirConditionar_Reciver ac) {
		super();
		this.ac = ac;
	}

	@Override
	public void execute() {
		this.ac.turnOnAc();

	}

	@Override
	public void undo() {
		this.ac.turnOffAc();
	}

}
