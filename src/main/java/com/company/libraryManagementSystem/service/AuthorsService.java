package com.company.libraryManagementSystem.service;

import com.company.libraryManagementSystem.model.Authors;

import java.util.List;

public interface AuthorsService {
    public List<Authors> getAuthors();
    public Authors saveAuthors(Authors authors);
}
