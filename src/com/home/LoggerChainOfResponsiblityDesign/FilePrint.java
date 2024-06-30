package com.home.LoggerChainOfResponsiblityDesign;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FilePrint implements LogPlace {

	private String filename;

	public FilePrint(String filename) {
		super();
		this.filename = filename;
	}

	@Override
	public void printlog(String message) {
		try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
			writer.println(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
