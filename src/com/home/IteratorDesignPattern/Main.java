package com.home.IteratorDesignPattern;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		List<Book> exampleList = new ArrayList<>();
		Library lib = new Library(exampleList);
		Iterator it =  lib.createIterator();
		
		System.out.println(it.next()); //if it's null then list is empty

	}

}
