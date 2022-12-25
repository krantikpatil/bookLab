package com.booklab.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.booklab.model.Book;
import com.booklab.model.Registration;
import com.booklab.service.BookService;
import com.booklab.service.UserService;

@Controller
public class BaseController {
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Autowired
    BookService bookService;
	
    @Autowired(required=false)
	private UserService userService;
    
    @GetMapping("/googleProtect")
    public String googleLogin(Principal principal) {
    	
    	return "GooglePage";
    }
	
	@GetMapping("/")
	public String test() {
		
		return "Home";
	}
	
	@PostMapping("addBook")
	public String addBook() {
		
		return "Admin/AddBook";
	}
	
	@PostMapping("/addBookData")
	public String addbook(@ModelAttribute("addBookObject") Book book, Model model, @RequestParam("profileImage") MultipartFile file) throws IOException {	
		
		if(file.isEmpty()) {
			
			System.out.println("File is empty...");
		}
		else {
			book.setImage(file.getOriginalFilename());    
			
			File saveFile = new ClassPathResource("static/IMAGE").getFile();
			
			Path path = Paths.get(saveFile.getAbsolutePath()+File.separator+file.getOriginalFilename());
			
			Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
			
			System.out.println("File uploaded successfully....!");
		}
		System.out.println(book);
		bookService.addBook(book);
		model.addAttribute("massage", "Book Added Successfully !...");
		
		return "Admin/AddBook";
	}
	@GetMapping("/regi")
	public String registrationPage(Model model) {
		
		model.addAttribute("regiObject", new Registration());
		
		return "Registration";
	}
	
	@PostMapping("/regiFormData")
	public String RegistrationFormData(@ModelAttribute("regiObject") Registration regi, Model model) {
		
		
		 System.out.println(regi);	
		 regi.setPassword(encoder.encode(regi.getPassword()));
		 System.out.println(regi);	
		 Registration user= userService.userRegistration(regi);
		 System.out.println("Added User");
		 System.out.println(user);
		 model.addAttribute("Message", "User Added Successfully !...");
		 return "Registration";
	}
	@GetMapping("/loginn")
	public String login() {
		
		return "login";
	}
	
	@GetMapping("/signIn")
	public String login2() {
		
		return "LoginTest";
	}
	
		

}
