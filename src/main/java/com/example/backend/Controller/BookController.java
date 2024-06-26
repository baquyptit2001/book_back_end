package com.example.backend.Controller;

import com.example.backend.Model.Book;
import com.example.backend.Service.Service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import java.util.*;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/book/{id}")
    public Optional<Book> getById(@PathVariable("id") Long bookId) {
        return bookService.findById(bookId);
    }

    @PostMapping("/add")
    public ResponseEntity<Book> add(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.add(book), CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Book> update(@RequestBody Book theBook) {
        return new ResponseEntity<>(bookService.update(theBook), OK);
    }

    @DeleteMapping("/book/delete/{id}")
    public void delete(@PathVariable("id") Long bookId) {
        bookService.delete(bookId);
    }

}
