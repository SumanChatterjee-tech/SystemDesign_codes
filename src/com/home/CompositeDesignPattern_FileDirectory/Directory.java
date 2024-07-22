package com.home.CompositeDesignPattern_FileDirectory;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem {
	String name;
	List<FileSystem> fileSystem;
	public Directory(String name) {
		super();
		this.name = name;
		this.fileSystem = new ArrayList<>();
	}
	
	public void add(FileSystem fileSystem) {
		this.fileSystem.add(fileSystem);
	}

	@Override
	public void print() {
		   System.out.println("Directory name " + name);

	        for(FileSystem fileSystemObj : fileSystem){
	            fileSystemObj.print();
	        }
	}
}
