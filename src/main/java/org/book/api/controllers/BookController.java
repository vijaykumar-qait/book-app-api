package org.book.api.controllers;

import org.book.api.beans.Book;
import org.book.api.services.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/book")
public class BookController {
    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book addedBook = bookService.addBook(book);
        logger.info("** Book Added Successfully **");
        return ResponseEntity.ok(addedBook);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") int id, @RequestBody Book book) {
        Book updateBook = bookService.updateBook(id, book);
        logger.info("** Book Updated Successfully **");
        return ResponseEntity.ok(updateBook);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable("id") int id) {
        Book deleteBook = bookService.deleteBook(id);
        logger.info("** Book Deleted Successfully **");
        return ResponseEntity.ok(deleteBook);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") int id) {
        Book book = bookService.getBook(id);
        return ResponseEntity.ok(book);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        logger.info("** All Books Successfully **");
        return ResponseEntity.ok(books);
    }

    @GetMapping("/author")
    public ResponseEntity<List<Book>> getAllBooksByAuthor(@RequestParam("author") String author) {
        List<Book> books = bookService.getBooksByAuthor(author);
        logger.info("** All Books By Author Successfully **");
        return ResponseEntity.ok(books);
    }

    @GetMapping("/title")
    public ResponseEntity<List<Book>> getAllBooksByTitle(@RequestParam("title") String title) {
        List<Book> books = bookService.getBooksByTitle(title);
        logger.info("** All Books By Title Successfully **");
        return ResponseEntity.ok(books);
    }
}
