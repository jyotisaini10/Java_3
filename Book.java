package com.library.model;

public class Book {
    private int bookId;
    private String title;
    private String author;
    private String genre;
    private boolean available;

    public Book(int bookId, String title, String author, String genre, boolean available) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.available = available;
    }

    // Getters and setters
    public int getBookId() { return bookId; }
    public void setBookId(int bookId) { this.bookId = bookId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    // Method to be overridden for polymorphism
    public String getType() {
        return "General";
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId +
               ", Title: " + title +
               ", Author: " + author +
               ", Genre: " + genre +
               ", Available: " + available +
               ", Type: " + getType();
    }

    public void displayBookInfo() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Genre: " + genre);
        System.out.println("Available: " + available);
        System.out.println("Type: " + getType());
    }
}


public class FictionBook extends Book {
    public FictionBook(int bookId, String title, String author, String genre, boolean available) {
        super(bookId, title, author, genre, available);
    }

    @Override
    public String getType() {
        return "Fiction";
    }
}


public class NonFictionBook extends Book {
    public NonFictionBook(int bookId, String title, String author, String genre, boolean available) {
        super(bookId, title, author, genre, available);
    }

    @Override
    public String getType() {
        return "Non-Fiction";
    }
}

