package com.home.Configuration_MememtoDesignPattern;

public class ConfigurationOriginator {

	int height;
	int width;
	
	public ConfigurationOriginator(int height, int width) {
		super();
		this.height = height;
		this.width = width;
	}
	
	public ConfigurationMememto createMememto() {
		return new ConfigurationMememto(this.height, this.width);
	}
	
	public void restoreMememto(ConfigurationMememto mememto) {
		this.height = mememto.height;
		this.width = mememto.width;
	}
}
