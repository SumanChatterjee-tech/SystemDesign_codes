package com.home.LibraryManagementSystem;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class LibraryManagement {

	Map<String, Book> listOfBooks;
	Map<String, Member> listOfMember;
	List<BorrowingRule> borrowingRules;
	
	public LibraryManagement() {
		this.listOfBooks = new ConcurrentHashMap<>();
		this.listOfMember = new ConcurrentHashMap<>();
		this.borrowingRules = new ArrayList<>();
	}
	
	public void addMember(Member member) {
		this.listOfMember.put(member.getId(), member);
	}
	
	public void removeMember(Member member) {
		this.listOfMember.remove(member.getId());
	}
	
	public void addBook(Book book) { this.listOfBooks.put(book.getId(), book);}
    public void removeBook(String id) { this.listOfBooks.remove(id); }
    
    
    public void addRule(BorrowingRule rule) {
    	this.borrowingRules.add(rule);
    }
    
    public void boorowABook(Member memberId, Book bookId) throws Exception {
    	Member member = listOfMember.get(memberId);
    	Book book  = listOfBooks.get(bookId);
    	
    	for(BorrowingRule rule: borrowingRules) {
    		try {
				if(!rule.validate(member, book)) throw new Exception("not eligible to borrow a book");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	
    	book.setAvailable(false);
    	BorrowedRecord record = new BorrowedRecord(book, new Date());
    	member.getListOfBorrowedBooks().add(record);
    	return;
    }

}
