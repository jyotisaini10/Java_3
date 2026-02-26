package com.library.model;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private List<Book> books;

    public Catalog() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public Book findBookById(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }
        return null;
    }

    public void displayCatalog() {
        System.out.println("Catalog:");
        for (Book book : books) {
            System.out.println("  " + book);
        }
    }

    public void displayAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println("  " + book);
            }
        }
    }

    public boolean updateBookStatus(int bookId, boolean available) {
        Book book = findBookById(bookId);
        if (book != null) {
            book.setAvailable(available);
            return true;
        }
        return false;
    }
}