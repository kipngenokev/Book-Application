package com.asan.bookapplication.service;

import com.asan.bookapplication.entity.Book;
import com.asan.bookapplication.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public Book addBook(Book book) {
         return bookRepository.save(book);

    }

    public Book getBookByName(String bookName) {
        return bookRepository.findBookByTitle(bookName);
    }

    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
