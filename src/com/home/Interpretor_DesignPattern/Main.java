package com.home.Interpretor_DesignPattern;

public class Main {

	public static void main(String[] args) {
		Context c = new Context();
		c.put('A', 2);
		c.put('B', 3);

		AbstractExpression expression1 = new MultiplyNonTerminalExpression(new NumberTerminalExpression('A'), 
				new NumberTerminalExpression('B'));
		
		System.out.println(expression1.interprate(c));
	}

}
