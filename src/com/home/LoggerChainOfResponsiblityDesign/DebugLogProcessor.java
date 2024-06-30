package com.home.LoggerChainOfResponsiblityDesign;

public class DebugLogProcessor extends LoggerProcessor{

	public DebugLogProcessor(LoggerProcessor nextloggerProcessor) {
		super(nextloggerProcessor);
		// TODO Auto-generated constructor stub
	}
	
	public void log(LogLevels loglevel, String message, LogPlace logPlace) {
		if(loglevel == LogLevels.DEBUG) {
			logPlace.printlog(message);
		}else {
			super.log(loglevel, message, logPlace);
		}
	}
}
