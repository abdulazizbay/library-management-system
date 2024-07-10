package com.company.libraryManagementSystem.controllers;


import com.company.libraryManagementSystem.model.Books;
import com.company.libraryManagementSystem.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BooksController {
    @Autowired
    public BooksService booksService;

    @GetMapping("/getAllBooks")
    public List<Books> getAllBooks() {
        return booksService.getAllBooks();
    }
    @PostMapping("/save")
    public ResponseEntity<?> saveBook(@RequestBody Books books) {
        try {
            Books savedBook = booksService.saveBook(books);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
        }catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable long id) {
        try {
            booksService.deleteBook(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    @PutMapping("/update")
    public ResponseEntity<?> updateBook(@RequestBody Books books) {
        try {
            Books updatedBook = booksService.updateBook(books);
            return ResponseEntity.ok(updatedBook);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
