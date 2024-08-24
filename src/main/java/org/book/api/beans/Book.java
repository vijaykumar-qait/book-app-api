package org.book.api.beans;

public class Book {
    private int bookId;
    private String title;
    private String author;
    private String publications;
    private double price;
    private String subject;

    public Book(int bookId, String title, String author, double v, String publisher, String subject) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.publications = publisher;
        this.price = v;
        this.subject = subject;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublications() {
        return publications;
    }

    public void setPublications(String publications) {
        this.publications = publications;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
