package com.home.LoggerChainOfResponsiblityDesign;

public class ErrorLogProcessor extends LoggerProcessor {
	public ErrorLogProcessor(LoggerProcessor nextloggerProcessor) {
		super(nextloggerProcessor);
		// TODO Auto-generated constructor stub
	}
	
	public void log(LogLevels loglevel, String message, LogPlace logPlace) {
		if(loglevel == LogLevels.ERROR) {
			logPlace.printlog(message);
		}else {
			super.log(loglevel, message, logPlace);
		}
	}
}
