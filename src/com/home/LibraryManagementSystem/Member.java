package com.home.LibraryManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Member {
	private String id;
	private String name;
	private String contactInfo;
	private List<BorrowedRecord> listOfBorrowedBooks;
	
	public Member(String id, String name, String contactInfo) {
		super();
		this.id = id;
		this.name = name;
		this.contactInfo = contactInfo;
		this.listOfBorrowedBooks = new ArrayList<>();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}
	public List<BorrowedRecord> getListOfBorrowedBooks() {
		return listOfBorrowedBooks;
	}
	public void setListOfBorrowedBooks(List<BorrowedRecord> listOfBorrowedBooks) {
		this.listOfBorrowedBooks = listOfBorrowedBooks;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", contactInfo=" + contactInfo + "]";
	}
}
