package com.home.Configuration_MememtoDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class Caretaker {
	List<ConfigurationMememto> configMememto;

	public Caretaker() {
		this.configMememto = new ArrayList<>();
	}
	
	public void addMememto(ConfigurationMememto configurationMememto) {
		this.configMememto.add(configurationMememto);
	}
	
	public ConfigurationMememto undo() {
		if(!this.configMememto.isEmpty()) {
			ConfigurationMememto result =  this.configMememto.get(this.configMememto.size()-1);//take the last mememto
			this.configMememto.remove(this.configMememto.size()-1); //and remove it
			return result;
		}
		return null;
	}
}
