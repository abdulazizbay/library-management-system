package com.company.libraryManagementSystem.service;

import com.company.libraryManagementSystem.model.Books;
import com.company.libraryManagementSystem.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BooksServiceImpl implements BooksService{
    @Autowired
    private BooksRepository booksRepository;

    @Override
    public List<Books> getAllBooks() {
        return booksRepository.findAll();
    }

    @Cacheable("books")
    @Override
    @Transactional
    public Books saveBook(Books book) {
        validateBook(book);
        Optional<Books>  existingBook = booksRepository.findByTitle(book.getTitle());
        if(existingBook.isPresent()) {
            throw new IllegalArgumentException("This book already exists");
        }
        return booksRepository.save(book);
    }

    @Override
    public void deleteBook(long id) {
        booksRepository.deleteById(id);
    }

    public Optional<Books> getBookByTitle(Books books) {
        Optional<Books> book = booksRepository.findByTitle(books.getTitle());
        if(book.isPresent()) {
            return book;
        }else{
            throw new IllegalArgumentException("This book does not exist");
        }
    }

    @Override
    public Books updateBook(Books book) {
        validateBook(book);
        Optional<Books> existingBook = booksRepository.findById(book.getId());
        if (existingBook.isPresent()) {
            Books updatedBook = existingBook.get();
            updatedBook.setTitle(book.getTitle());
            updatedBook.setAuthor(book.getAuthor());
            updatedBook.setGenre(book.getGenre());
            return booksRepository.save(updatedBook);
        } else {
            throw new IllegalArgumentException("Book not found");
        }
    }
    private void validateBook(Books book) {
        if (book.getTitle() == null || book.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Book title cannot be null or empty");
        }
        if (book.getAuthor() == null) {
            throw new IllegalArgumentException("Author cannot be null");
        }
    }
}
