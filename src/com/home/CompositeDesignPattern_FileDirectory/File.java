package com.home.CompositeDesignPattern_FileDirectory;

public class File implements FileSystem{
	String name;

	public File(String name) {
		super();
		this.name = name;
	}

	@Override
	public void print() {
		System.out.println("The file name is"+ this.name);	
	}
	
}
