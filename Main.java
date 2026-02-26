package com.library.test;

import com.library.model.*;

public class Main {
    public static void main(String[] args) {
        // Create catalog
        Catalog catalog = new Catalog();

        // --- Problem 5 Test: Inheritance and Polymorphism ---
        System.out.println("=== Problem 5: Inheritance and Polymorphism ===");
        FictionBook fiction = new FictionBook(3, "Fiction Novel", "Fiction Author", "Fiction", true);
        NonFictionBook nonFiction = new NonFictionBook(4, "Non-Fiction Guide", "Non-Fiction Author", "Non-Fiction", true);

        // Polymorphic display
        fiction.displayBookInfo();
        System.out.println();
        nonFiction.displayBookInfo();

        // Add them to catalog for later use
        catalog.addBook(fiction);
        catalog.addBook(nonFiction);

        // --- Problem 6: Main Program Simulation ---
        System.out.println("\n=== Problem 6: Main Program (Borrow/Return Simulation) ===");

        // Create books from Problem 1 and 2
        Book book1 = new Book(1, "Java Basics", "John Doe", "Programming", true);
        Book book2 = new Book(2, "Advanced Java", "Jane Smith", "Programming", true); // initially available

        catalog.addBook(book1);
        catalog.addBook(book2);

        // Create user
        User alice = new User(101, "Alice", "alice@example.com", "123-456-7890");

        // Display initial catalog
        System.out.println("\nInitial Catalog:");
        catalog.displayCatalog();

        // Test Case 1: Alice borrows book 1
        System.out.println("\n--- Alice borrows Book ID 1 (Java Basics) ---");
        if (alice.borrowBook(1, catalog)) {
            System.out.println("Borrow successful.");
        } else {
            System.out.println("Borrow failed.");
        }

        // Display catalog after borrow
        System.out.println("\nCatalog after borrow:");
        catalog.displayCatalog();

        // Display user info
        System.out.println("\nUser Alice after borrow:");
        alice.displayUserInfo();

        // Test Case 2: Add another book (already added) – we can show catalog again
        System.out.println("\n--- Adding Book ID 2 (already in catalog) ---");
        // No action needed; just display catalog to show book2 is still available.
        System.out.println("Current Catalog:");
        catalog.displayCatalog();

        // Additional simulation: Alice returns book 1
        System.out.println("\n--- Alice returns Book ID 1 ---");
        if (alice.returnBook(1, catalog)) {
            System.out.println("Return successful.");
        } else {
            System.out.println("Return failed.");
        }

        System.out.println("\nCatalog after return:");
        catalog.displayCatalog();

        System.out.println("\nUser Alice after return:");
        alice.displayUserInfo();

        // Try to borrow an unavailable book
        System.out.println("\n--- Alice tries to borrow Book ID 1 again (now available) ---");
        if (alice.borrowBook(1, catalog)) {
            System.out.println("Borrow successful.");
        } else {
            System.out.println("Borrow failed.");
        }
        alice.displayUserInfo();
    }
}
