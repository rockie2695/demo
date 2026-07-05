package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.BookRequest;
import com.example.demo.Service.BookService;
import com.example.demo.model.Book;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books/{bookId}")
    public ResponseEntity<Book> getBook(@PathVariable Integer bookId) {
        Book book = bookService.getBookById(bookId);

        if (book != null) {
            return ResponseEntity.status(HttpStatus.OK).body(book);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/books")
    public ResponseEntity<Book> createBook(@RequestBody BookRequest bookRequest) {
        Integer bookId = bookService.createBook(bookRequest);

        Book book = bookService.getBookById(bookId);

        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }

    @PutMapping("/books/{bookId}")
    public ResponseEntity<Book> updateBook(@PathVariable Integer bookId,
            @RequestBody BookRequest bookRequest) {

        // 檢查 book 是否存在Book
        Book book = bookService.getBookById(bookId);

        if (book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // 修改 Book 的數據
        bookService.updateBook(bookId, bookRequest);

        Book updatedBook = bookService.getBookById(bookId);

        return ResponseEntity.status(HttpStatus.OK).body(updatedBook);
    }
}
