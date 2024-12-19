package com.venkatesh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.venkatesh.Repository.BookRepository;
import com.venkatesh.entity.Book;

@Controller
public class BookController {
	@Autowired
	BookRepository bookRepository;
	
	
	//http://localhost:8080/addBook
	@GetMapping("/addBook")
	public String saveAddBookForm(Model model) {
		model.addAttribute("book",new Book());
		return"addBook";
	}
	
	@PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("book") Book book) {
        bookRepository.save(book);
        return "redirect:/books";
    }
	//http://localhost:8080/books
	@GetMapping("/books")
    public String showBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "bookList";
    }
	
	

}
