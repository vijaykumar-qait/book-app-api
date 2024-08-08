package org.book.api.services;

import org.book.api.beans.Book;
import org.book.api.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    BookDao bookDao;

    @Override
    public Book addBook(Book book) {
        bookDao.addBook(book);
        return book;
    }

    @Override
    public Book updateBook(int bookId, Book book) {
        /* Using Java Stream */

//        books.stream()
//                .filter(bookVar -> bookVar.getBookId() == bookId)
//                .findFirst()
//                .ifPresent(bookVar -> {
//                    bookVar.setTitle(book.getTitle());
//                    bookVar.setAuthor(book.getAuthor());
//                    bookVar.setPrice(book.getPrice());
//                    bookVar.setPublications(book.getPublications());
//                    bookVar.setSubject(book.getSubject());
//                });
//        return book;

        /* Using JDBC */
        return bookDao.updateBook(bookId, book);
    }

    @Override
    public Book deleteBook(int bookId) {
        /* Using Java Stream */

//        Book book = books.stream().
//                filter(bookVar -> bookVar.getBookId() == bookId).findFirst().orElse(null);
//        boolean isDeleted = books.removeIf(bookVar -> bookVar.getBookId() == bookId);
//        return isDeleted == true ? book : new Book();

        /* Using JDBC */
        return bookDao.deleteBook(bookId);
    }

    @Override
    public Book getBook(int bookId) {
        /* Using Java Stream */

//        Book book = books.stream().
//                            filter(bookVar -> bookVar.getBookId() == bookId).findFirst().orElse(null);
//        return book != null ? book : new Book();

        /* Using JDBC */
        return bookDao.getBook(bookId);
    }

    @Override
    public List<Book> getAllBooks() {
        /* Using Java Stream */
//        return books;

        /* Using JDBC */
        return bookDao.getAllBooks();
    }

    @Override
    public List<Book> getBooksByAuthor(String author) {
        /* Using Java Stream */

//        List<Book> authorBooks = books.stream().
//                                        filter(bookVar -> bookVar.getAuthor().equals(author)).collect(Collectors.toList());
//        return authorBooks;

        /* Using JDBC */
        return bookDao.getBooksByAuthor(author);
    }

    @Override
    public List<Book> getBooksByTitle(String title) {
        /* Using Java Stream */

//        List<Book> titleBooks = books.stream().
//                                        filter(bookVar -> bookVar.getTitle().equals(title)).collect(Collectors.toList());
//        return titleBooks;

        /* Using JDBC */
        return bookDao.getBooksByTitle(title);
    }
}
