package com.home.LinkedInDesign;

public interface Subject {

	public void addObserver(Observers obs);
	public void removeObserver(Observers obs);
	public void notifyObserver();
}
