package com.home.LibraryManagementSystem;

public interface BorrowingRule {

	public boolean validate(Member member, Book book);
}
