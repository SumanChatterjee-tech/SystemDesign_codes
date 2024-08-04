package com.home.IteratorDesignPattern;

import java.util.List;

public class BookListIterator implements Iterator {

	List<Book> bookList;
	int index =0;
	
	public BookListIterator(List<Book> bookList) {
		super();
		this.bookList = bookList;
	}

	@Override
	public boolean hasNext() {
		return index < this.bookList.size()-1;
	}

	@Override
	public Object next() {
		if(this.hasNext()) {
			return bookList.get(index++);
		}
		return null;
	}

}
