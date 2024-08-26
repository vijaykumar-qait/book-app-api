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

}
