package com.home.CommandDesignPattern;

import java.util.Stack;

public class MyRemoteControl_Invoker {

	ICommand command;
	Stack<ICommand> st = new Stack<>();
	
	public MyRemoteControl_Invoker() {
	}
	
	public void setCommand(ICommand iCommand) {
		this.command = iCommand;
	}
	
	public void pressButton() {
		this.command.execute();
		st.add(command);
	}
	
	public void undo() {
		if(!st.isEmpty()) { //take the last command happned, pop it, and undo that.
			ICommand lastCommand  = st.pop();
			lastCommand.undo();
		}
	}
}
