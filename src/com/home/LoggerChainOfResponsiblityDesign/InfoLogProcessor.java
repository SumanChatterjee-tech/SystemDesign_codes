package com.home.LoggerChainOfResponsiblityDesign;

public class InfoLogProcessor extends LoggerProcessor{
	public InfoLogProcessor(LoggerProcessor nextloggerProcessor) {
		super(nextloggerProcessor);
		// TODO Auto-generated constructor stub
	}
	
	public void log(LogLevels loglevel, String message, LogPlace logPlace) {
		if(loglevel == LogLevels.INFO) {
			logPlace.printlog(message);
		}else {
			super.log(loglevel, message, logPlace);
		}
	}
}
