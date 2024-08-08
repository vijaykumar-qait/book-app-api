package org.book.api.dao;

import org.book.api.beans.Book;
import org.book.api.exception.BookFoundException;
import org.book.api.exception.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Book addBook(Book book) {
        String sql = "insert into books values(?,?,?,?,?,?)";
        Object[] args = {book.getBookId(), book.getTitle(), book.getAuthor(), book.getPublications(), book.getPrice(), book.getSubject()};
        //Check if book already exist
        String checkSql = "select count(*) from books where bookId=?";
        Object[] checkArgs = {book.getBookId()};
        int count = jdbcTemplate.queryForObject(checkSql, checkArgs, Integer.class);
        if (count > 0)
            throw new BookFoundException();
        int rows = jdbcTemplate.update(sql, args);
        return rows > 0 ? book : null;
    }

    @Override
    public Book updateBook(int bookId, Book book) {
        String sql = "update books set title = ?, author = ?, publications = ?, price = ?, subject = ?  where bookId = ?";
        Object[] args = {book.getTitle(), book.getAuthor(), book.getPublications(), book.getPrice(), book.getSubject(), bookId};
        int rows = jdbcTemplate.update(sql, args);
        book.setBookId(bookId);
        return rows > 0 ? book : null;
    }

    @Override
    public Book deleteBook(int bookId) {
        Book book = getBook(bookId);
        String sql = "delete from books where bookId = ?";
        int rows = jdbcTemplate.update(sql, bookId);
        return rows > 0 ? book : null;
    }

    @Override
    public Book getBook(int bookId) {
        String sql = "select * from books where bookId = ?";
        String checkSql = "select count(*) from books where bookId = ?";
        int count = jdbcTemplate.queryForObject(checkSql, new Object[]{bookId}, Integer.class);
        if (count == 0) {
            throw new BookNotFoundException();
        }
        Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class), bookId);
        return book;
    }

    @Override
    public List<Book> getAllBooks() {
        String sql = "select * from books";
        List<Book> bookList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
        return bookList;
    }

    @Override
    public List<Book> getBooksByAuthor(String author) {
        String sql = "select * from books where author = ?";
        String checkSql = "select count(*) from books where author = ?";
        int count = jdbcTemplate.queryForObject(checkSql, new Object[]{author}, Integer.class);
        if(count == 0) {
            throw new BookNotFoundException();
        }
        List<Book> bookList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class), author);
        return bookList;
    }

    @Override
    public List<Book> getBooksByTitle(String title) {
        String sql = "select * from books where title = ?";
        String checkSql = "select count(*) from books where title = ?";
        int count = jdbcTemplate.queryForObject(checkSql, new Object[]{title}, Integer.class);
        if(count == 0) {
            throw new BookNotFoundException();
        }
        List<Book> bookList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class), title);
        return bookList;
    }
}
