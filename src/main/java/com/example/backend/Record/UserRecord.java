package com.example.backend.Record;

import com.example.backend.Model.Book;

import java.util.List;

public record UserRecord(Long id, String firstName, String lastName, String email, List<Book> books, String role) {
}
