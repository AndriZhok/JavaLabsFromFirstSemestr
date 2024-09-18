package main;

import book.Book;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create an array (or list) of books
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "Book One", "Author A", "Publisher X", 2000, 300, 29.99));
        books.add(new Book(2, "Book Two", "Author B", "Publisher Y", 2010, 150, 19.99));
        books.add(new Book(3, "Book Three", "Author A", "Publisher X", 2020, 400, 39.99));
        books.add(new Book(4, "Book Four", "Author C", "Publisher Z", 2015, 250, 25.99));

        // a) List books by a specific author
        System.out.println("Books by Author A:");
        listBooksByAuthor(books, "Author A");

        // b) List books by a specific publisher
        System.out.println("\nBooks published by Publisher X:");
        listBooksByPublisher(books, "Publisher X");

        // c) List books published after a specific year
        System.out.println("\nBooks published after 2010:");
        listBooksAfterYear(books, 2010);
    }

    // a) Method to list books by a specific author
    public static void listBooksByAuthor(List<Book> books, String author) {
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                System.out.println(book);
            }
        }
    }

    // b) Method to list books by a specific publisher
    public static void listBooksByPublisher(List<Book> books, String publisher) {
        for (Book book : books) {
            if (book.getPublisher().equals(publisher)) {
                System.out.println(book);
            }
        }
    }

    // c) Method to list books published after a specific year
    public static void listBooksAfterYear(List<Book> books, int year) {
        for (Book book : books) {
            if (book.getYear() > year) {
                System.out.println(book);
            }
        }
    }
}