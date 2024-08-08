package org.book.api.services;

import org.book.api.beans.Book;

import java.util.List;

public interface BookService {
    public Book addBook(Book book);
    public Book updateBook(int bookId, Book book);
    public Book deleteBook(int bookId);
    public Book getBook(int bookId);
    public List<Book> getAllBooks();
    public List<Book> getBooksByAuthor(String author);
    public List<Book> getBooksByTitle(String title);
}
