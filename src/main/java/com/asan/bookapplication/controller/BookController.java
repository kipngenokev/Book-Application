package com.asan.bookapplication.controller;

import com.asan.bookapplication.entity.Book;
import com.asan.bookapplication.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book/v1")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/addBook")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book savedBook = bookService.addBook(book);
        return ResponseEntity.ok(savedBook);
    }

    @GetMapping("/getBook/{bookName}")
    public ResponseEntity<Book> getBookByName(@PathVariable ("bookName") String bookName) {
        Book foundBook = bookService.getBookByName(bookName);
        return ResponseEntity.ok(foundBook);
    }

    @GetMapping("/getAllBooks")
    public ResponseEntity<List> getAllBooks() {
        List<Book> allBooks= bookService.getAllBooks();
        return ResponseEntity.ok(allBooks);
    }

    @PutMapping("/updateBook")
    public ResponseEntity<Book> updateBook(@RequestBody Book book) {
        Book updateBook = bookService.updateBook(book);
        return ResponseEntity.ok(updateBook);
    }

    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") Integer id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }
}
