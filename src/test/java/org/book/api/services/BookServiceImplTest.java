package org.book.api.services;

import org.book.api.beans.Book;
import org.book.api.dao.BookDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookServiceImplTest {
    @Mock
    private BookDao bookDao;

    @InjectMocks
    private BookServiceImpl bookService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddBook() {
        Book book = new Book(1, "Title", "Author", 10.0, "Publisher", "Subject");
        when(bookDao.addBook(any(Book.class))).thenReturn(book);
        Book addedBook = bookService.addBook(book);
        assertEquals(book, addedBook);
        verify(bookDao, times(1)).addBook(any(Book.class));
    }

    @Test
    void testUpdateBook() {
        Book book = new Book(1, "Updated Title", "Updated Author", 150.0, "Updated Publisher", " Updated Subject");
        when(bookDao.updateBook(anyInt(), any(Book.class))).thenReturn(book);
        Book updatedBook = bookService.updateBook(1, book);
        assertEquals(book, updatedBook);
        verify(bookDao, times(1)).updateBook(anyInt(), any(Book.class));
    }

    @Test
    void testDeleteBook() {
        Book book = new Book(1, "Title", "Author", 10.0, "Publisher", "Subject");
        when(bookDao.deleteBook(anyInt())).thenReturn(book);
        Book deletedBook = bookService.deleteBook(1);
        assertEquals(book, deletedBook);
        verify(bookDao, times(1)).deleteBook(anyInt());
    }

    @Test
    void testGetAllBooks() {
        List<Book> bookList = Arrays.asList(
                new Book(1, "Title1", "Author1", 10.0, "Publisher1", "Subject1"),
                new Book(2, "Title2", "Author2", 20.0, "Publisher2", "Subject2")
        );
        when(bookDao.getAllBooks()).thenReturn(bookList);
        List<Book> allBooks = bookService.getAllBooks();
        assertEquals(bookList, allBooks);
        verify(bookDao, times(1)).getAllBooks();
    }

    @Test
    void testGetBookById() {
        Book book = new Book(1, "Title1", "Author1", 10.0, "Publisher1", "Subject1");
        when(bookDao.getBook(anyInt())).thenReturn(book);
        Book getBookById = bookService.getBook(1);
        assertEquals(book, getBookById);
        verify(bookDao, times(1)).getBook(anyInt());
    }
}
