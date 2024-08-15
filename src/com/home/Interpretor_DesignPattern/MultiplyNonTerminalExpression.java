package com.home.Interpretor_DesignPattern;

public class MultiplyNonTerminalExpression implements AbstractExpression{

	AbstractExpression leftrexpression;
	AbstractExpression rightExpression;
	
	public MultiplyNonTerminalExpression(AbstractExpression leftrexpression, AbstractExpression rightExpression) {
		super();
		this.leftrexpression = leftrexpression;
		this.rightExpression = rightExpression;
	}

	@Override
	public int interprate(Context context) {
		return leftrexpression.interprate(context) * rightExpression.interprate(context);
	}
	
	
}
