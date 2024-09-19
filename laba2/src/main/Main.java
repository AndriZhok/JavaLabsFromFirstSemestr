package main;

import book.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "Book One", "Author A", "Publisher X", 2000, 300, 29.99));
        books.add(new Book(2, "Book Two", "Author B", "Publisher Y", 2010, 150, 19.99));
        books.add(new Book(3, "Book Three", "Author A", "Publisher X", 2020, 400, 39.99));
        books.add(new Book(4, "Book Four", "Author C", "Publisher Z", 2015, 250, 25.99));

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть ім'я автора: ");
        String author = scanner.nextLine();
        System.out.println("\nКниги автора " + author + ":");
        listBooksByAuthor(books, author);

        System.out.print("\nВведіть назву видавництва: ");
        String publisher = scanner.nextLine();
        System.out.println("\nКниги, видані видавництвом " + publisher + ":");
        listBooksByPublisher(books, publisher);

        System.out.print("\nВведіть рік: ");
        int year = scanner.nextInt();
        System.out.println("\nКниги, випущені після " + year + ":");
        listBooksAfterYear(books, year);
    }

    public static void listBooksByAuthor(List<Book> books, String author) {
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(book);
            }
        }
    }

    public static void listBooksByPublisher(List<Book> books, String publisher) {
        for (Book book : books) {
            if (book.getPublisher().equalsIgnoreCase(publisher)) {
                System.out.println(book);
            }
        }
    }

    public static void listBooksAfterYear(List<Book> books, int year) {
        for (Book book : books) {
            if (book.getYear() > year) {
                System.out.println(book);
            }
        }
    }
}