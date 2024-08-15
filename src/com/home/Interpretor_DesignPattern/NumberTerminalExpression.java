package com.home.Interpretor_DesignPattern;

public class NumberTerminalExpression implements AbstractExpression{

	Character chars;

	public NumberTerminalExpression(Character chars) {
		super();
		this.chars = chars;
	}

	@Override
	public int interprate(Context context) {
		return context.get(this.chars);
	}
}
