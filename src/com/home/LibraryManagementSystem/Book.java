package com.home.LibraryManagementSystem;

public class Book {
	private String id;
	private String title;
	private String author;
	private String ISBN;
	private boolean isAvailable;
	
	public Book(String id, String title, String author, String iSBN) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		ISBN = iSBN;
		this.isAvailable = true;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", ISBN=" + ISBN + ", isAvailable="
				+ isAvailable + "]";
	}
}
