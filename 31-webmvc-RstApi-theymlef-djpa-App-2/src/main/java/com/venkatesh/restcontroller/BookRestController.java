package com.venkatesh.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.venkatesh.Repository.BookRepository;
import com.venkatesh.entity.Book;

@RestController
public class BookRestController {

    @Autowired
    BookRepository bookRepository;

    
 // Allow CORS for this specific endpoint
    @CrossOrigin(origins = "http://localhost:5173")  // React frontend URL
    @GetMapping(value = "/bookproductxml", produces = {"application/json","application/xml"})
    public ResponseEntity<List<Book>> getbookXml() {
        List<Book> books = bookRepository.findAll();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
    
    
    // Allow CORS for this specific endpoint
    @CrossOrigin(origins = "http://localhost:5173")  // React frontend URL
    @GetMapping(value = "/bookproducts", produces = {"application/json"})
    public ResponseEntity<List<Book>> getbookXmls() {
        List<Book> books = bookRepository.findAll();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
    
    
//    @CrossOrigin(origins = "http://localhost:5173")  // React frontend URL
//    @PostMapping( value = "/saveBookData", consumes = {"application/json","application/xml"})
//    public ResponseEntity<String> saveBookData(@RequestBody Book book) {
//    	String msg = "Book Add Succsfully";
//        bookRepository.save(book);
//        return  new ResponseEntity<>(msg, HttpStatus.CREATED);
//    }
    
    @CrossOrigin(origins = "http://localhost:5173")  // Adjust for production
    @PostMapping(value = "/books", consumes = {"application/json", "application/xml"})
    public ResponseEntity<String> saveBookData(@RequestBody Book book) {
        try {
            bookRepository.save(book); // Save the book to the database
            String msg = "Book added successfully!";
            return new ResponseEntity<>(msg, HttpStatus.CREATED);
        } catch (Exception e) {
            // Log error and return appropriate response
            String errorMsg = "Failed to add the book. Error: " + e.getMessage();
            return new ResponseEntity<>(errorMsg, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
}
