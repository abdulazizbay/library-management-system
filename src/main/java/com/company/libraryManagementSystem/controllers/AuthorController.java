package com.company.libraryManagementSystem.controllers;
import com.company.libraryManagementSystem.model.Authors;
import com.company.libraryManagementSystem.service.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
    @Autowired
    private AuthorsService authorsService;

    @PostMapping("/save")
    private ResponseEntity<?> save(@RequestBody Authors authors) {
        try{
            Authors createdAuthors = authorsService.saveAuthors(authors);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdAuthors);
        }catch (IllegalArgumentException e ){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
