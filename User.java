package com.library.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int userId;
    private String name;
    private String email;
    private String phone;
    private List<Integer> borrowedBookIds;  // Store IDs of borrowed books

    public User(int userId, String name, String email, String phone) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.borrowedBookIds = new ArrayList<>();
    }

    // Getters and setters
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public List<Integer> getBorrowedBookIds() { return borrowedBookIds; }

    // Borrow a book
    public boolean borrowBook(int bookId, Catalog catalog) {
        Book book = catalog.findBookById(bookId);
        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            borrowedBookIds.add(bookId);
            return true;
        }
        return false;
    }

    // Return a book
    public boolean returnBook(int bookId, Catalog catalog) {
        if (borrowedBookIds.contains(bookId)) {
            Book book = catalog.findBookById(bookId);
            if (book != null) {
                book.setAvailable(true);
                borrowedBookIds.remove(Integer.valueOf(bookId));
                return true;
            }
        }
        return false;
    }

    public void displayUserInfo() {
        System.out.println("User ID: " + userId);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Borrowed Books: " + borrowedBookIds);
    }
}