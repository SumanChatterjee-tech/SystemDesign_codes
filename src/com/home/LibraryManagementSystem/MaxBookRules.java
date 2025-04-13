package com.home.LibraryManagementSystem;

public class MaxBookRules implements BorrowingRule{
	
	private final int maxBooksAllowed;

    public MaxBookRules(int maxBooksAllowed) {
        this.maxBooksAllowed = maxBooksAllowed;
    }

	@Override
	public boolean validate(Member member, Book book) {
		long activeBooksWithMember = member.getListOfBorrowedBooks().stream().filter(checkBooks-> checkBooks.getReturnedDate() == null).count();
		if(activeBooksWithMember >= maxBooksAllowed) {
			System.out.println("Max borrowed books reached");
			return false;
		}
		return true;
	}

}
