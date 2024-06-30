package com.home.LoggerChainOfResponsiblityDesign;

public class Main {

	public static void main(String[] args) {
		LoggerProcessor logObject = new LoggerProcessor(new InfoLogProcessor(new ErrorLogProcessor(new DebugLogProcessor(null))));
		
		logObject.log(LogLevels.ERROR, "this is Error message", new ConsolePrintLog());
		logObject.log(LogLevels.INFO, "this is info message", new ConsolePrintLog());
		logObject.log(LogLevels.DEBUG, "this is debug message", new ConsolePrintLog());

	}

}
