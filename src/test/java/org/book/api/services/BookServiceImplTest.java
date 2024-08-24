package org.book.api.services;

import org.book.api.beans.Book;
import org.book.api.dao.BookDao;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class BookServiceImplTest {
    @Mock
    private BookDao bookDao;

    @InjectMocks
    private BookServiceImpl bookService;

//    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

//    @Test
    void testAddBook() {
        Book book = new Book(1, "Title", "Author", 10.0, "Publisher", "Subject");
        doNothing().when(bookDao).addBook(book);
        Book addedBook = bookService.addBook(book);
//        assertEquals(book, addedBook);
        verify(bookDao, times(1)).addBook(book);
    }

}
