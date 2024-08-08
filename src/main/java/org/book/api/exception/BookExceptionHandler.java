package org.book.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookExceptionHandler {
    @ExceptionHandler(value = BookFoundException.class)
    ResponseEntity<String> handleBookFoundException(BookFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.FOUND);
    }

    @ExceptionHandler(value = BookNotFoundException.class)
    ResponseEntity<String> handleBookNotFoundException(BookNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.OK);
    }
}
