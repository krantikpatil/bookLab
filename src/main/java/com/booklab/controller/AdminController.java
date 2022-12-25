package com.booklab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.booklab.model.Book;
import com.booklab.service.BookService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
    BookService bookService; 
	
	@GetMapping("addBook")
	public String addBook() {
		
		return "Admin/AddBook";
	}
	
	
	
	@GetMapping("viewBooks")
	public String viewBooks(Model model) {
		
		List<Book> books = bookService.viewBooks();
		model.addAttribute("books", books);
		
		System.out.println(books);
		
		return "Admin/ViewBooks";
	}

}
