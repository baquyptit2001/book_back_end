package com.example.backend.Service.Interface;

import com.example.backend.Model.Book;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    List<Book> getAllBooks();
    Book add(Book book);
    Optional<Book> findById(Long bookId);
    void delete(Long bookId);
    Book update(Book book);
}
