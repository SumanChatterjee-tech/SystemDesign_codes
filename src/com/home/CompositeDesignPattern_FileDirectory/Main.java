package com.home.CompositeDesignPattern_FileDirectory;

public class Main {

	public static void main(String[] args) {
		Directory topLevelDirectory = new Directory("Movie");
		FileSystem genericFile = new File("Border");
		topLevelDirectory.add(genericFile);
		
		Directory ComedeyDirectory = new Directory("Comedy Directory");
		FileSystem ComedyFile = new File("Golmal");
		ComedeyDirectory.add(ComedyFile);
		
		topLevelDirectory.add(ComedeyDirectory);
	}

}
