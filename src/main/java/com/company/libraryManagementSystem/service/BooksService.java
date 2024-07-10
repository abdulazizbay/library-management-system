package com.company.libraryManagementSystem.service;


import com.company.libraryManagementSystem.model.Books;

import java.util.List;
import java.util.Optional;

public interface BooksService {
    public List<Books> getAllBooks();
    public Books saveBook(Books book);
    public void deleteBook(long id);
    public Optional<Books> getBookByTitle(Books books);
    public Books updateBook(Books book);
}
