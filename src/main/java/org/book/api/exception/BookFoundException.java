package org.book.api.exception;

public class BookFoundException extends RuntimeException {
    public BookFoundException() {
        super("Book is already present");
    }
}
