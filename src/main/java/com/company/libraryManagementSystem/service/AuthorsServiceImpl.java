package com.company.libraryManagementSystem.service;

import com.company.libraryManagementSystem.model.Authors;
import com.company.libraryManagementSystem.repository.AuthorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorsServiceImpl implements AuthorsService{
    @Autowired
    private AuthorsRepository authorsRepository;
    @Override
    public List<Authors> getAuthors() {
        return authorsRepository.findAll();
    }

    @Override
    public Authors saveAuthors(Authors authors) {
        Optional<Authors> existingAuthor = authorsRepository.findAuthorsByName(authors.getName());
        if(existingAuthor.isPresent()  ){
            throw new IllegalArgumentException("Author already exists");
        }
        return authorsRepository.save(authors);
    }
    
}
