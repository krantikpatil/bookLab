package com.booklab.service;

import java.util.List;

import com.booklab.model.Book;

public interface BookService {

	public Book addBook(Book book);
	
	public List<Book> viewBooks();
}
