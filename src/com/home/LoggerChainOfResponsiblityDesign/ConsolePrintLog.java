package com.home.LoggerChainOfResponsiblityDesign;

public class ConsolePrintLog implements LogPlace {

	@Override
	public void printlog(String message) {
		System.out.println(message);
	}
}
