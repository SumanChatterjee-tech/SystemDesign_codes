package com.home.LibraryManagementSystem;

import java.util.Date;

public class BorrowedRecord {

	private Book borrowedBook;
	private Date borrowedDate;
	private Date dueDate;
	private Date returnedDate;
	
	public BorrowedRecord(Book borrowedBook, Date dueDate) {
		super();
		this.borrowedBook = borrowedBook;
		this.borrowedDate = new Date();
		this.dueDate = dueDate;
	}

	public Book getBorrowedBook() {
		return borrowedBook;
	}

	public void setBorrowedBook(Book borrowedBook) {
		this.borrowedBook = borrowedBook;
	}

	public Date getBorrowedDate() {
		return borrowedDate;
	}

	public void setBorrowedDate(Date borrowedDate) {
		this.borrowedDate = borrowedDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getReturnedDate() {
		return returnedDate;
	}

	public void setReturnedDate(Date returnedDate) {
		this.returnedDate = returnedDate;
	}

	@Override
	public String toString() {
		return "BorrowedRecord [borrowedBook=" + borrowedBook + ", borrowedDate=" + borrowedDate + ", dueDate="
				+ dueDate + ", returnedDate=" + returnedDate + "]";
	}
}
