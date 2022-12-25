package com.booklab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booklab.model.Book;
import com.booklab.repository.BookRepository;
@Service
public class BookServiceImpl implements BookService{
   @Autowired
	BookRepository bookRepo;
	
	@Override
	public Book addBook(Book book) {

		return bookRepo.save(book);
	}

	@Override
	public List<Book> viewBooks() {

		return bookRepo.findAll();
	}

}
