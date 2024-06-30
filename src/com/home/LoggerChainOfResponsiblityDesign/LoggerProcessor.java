package com.home.LoggerChainOfResponsiblityDesign;

public class LoggerProcessor {
	LoggerProcessor nextloggerProcessor;
	LogPlace logPlace;
	
	public LoggerProcessor(LoggerProcessor nextloggerProcessor) {
		super();
		this.nextloggerProcessor = nextloggerProcessor;
	}
	
	public void log(LogLevels loglevels, String message, LogPlace logPlace) {
		if(nextloggerProcessor !=  null) {
			nextloggerProcessor.log(loglevels, message, logPlace);
		}
	}
	
}
