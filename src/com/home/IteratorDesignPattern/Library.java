package com.home.IteratorDesignPattern;

import java.util.List;

public class Library {

	List<Book> bookList;

	public Library(List<Book> bookList) {
		super();
		this.bookList = bookList;
	}
	
	public Iterator createIterator() {
		return new BookListIterator(bookList);
	}
}
