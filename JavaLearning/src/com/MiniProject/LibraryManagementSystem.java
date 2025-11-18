package com.MiniProject;

// Library Management System – Single File Program

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// class: Book
class Book {
    private String bookId;
    private String title;
    private String author;
    private boolean issued;

    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.issued = false;
    }

    public String getBookId() { return bookId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isIssued() { return issued; }
    public void issue() { issued = true; }
    public void returnBook() { issued = false; }

    @Override
    public String toString() {
        return bookId + " | " + title + " | " + author + " | " +
                (issued ? "Issued" : "Available");
    }
}

// class: Member
class Member {
    private String memberId;
    private String name;
    private Map<String, LocalDate> borrowedBooks;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.borrowedBooks = new HashMap<>();
    }

    public String getMemberId() { return memberId; }
    public boolean hasBorrowed(String bookId) {
        return borrowedBooks.containsKey(bookId);
    }

    public void borrowBook(String bookId) {
        borrowedBooks.put(bookId, LocalDate.now());
    }

    public LocalDate returnBook(String bookId) {
        return borrowedBooks.remove(bookId);
    }
}

// custom exception
class BookNotAvailableException extends Exception {
    public BookNotAvailableException(String msg) { super(msg); }
}

// custom exception
class InvalidReturnException extends Exception {
    public InvalidReturnException(String msg) { super(msg); }
}

// class: Library
class Library {
    private Map<String, Book> books = new HashMap<>();
    private Map<String, Member> members = new HashMap<>();

    // method: Add book
    public void addBook(Book book) {
        books.put(book.getBookId(), book);
    }

    // method: Add member
    public void addMember(Member member) {
        members.put(member.getMemberId(), member);
    }

    // method: Issue book
    public void issueBook(String bookId, String memberId) throws BookNotAvailableException {
        Book book = books.get(bookId);
        Member member = members.get(memberId);

        if (book == null)
            throw new BookNotAvailableException("Book not found!");

        if (member == null)
            throw new BookNotAvailableException("Member not found!");

        if (book.isIssued())
            throw new BookNotAvailableException("Book is already issued!");

        book.issue();
        member.borrowBook(bookId);
        log("Issued Book: " + bookId + " to Member: " + memberId);
    }

    // method: Return book
    public void returnBook(String bookId, String memberId) throws InvalidReturnException {
        Book book = books.get(bookId);
        Member member = members.get(memberId);

        if (book == null || member == null)
            throw new InvalidReturnException("Invalid book or member.");

        if (!member.hasBorrowed(bookId))
            throw new InvalidReturnException("This member did not borrow the book.");

        LocalDate issuedDate = member.returnBook(bookId);
        book.returnBook();

        long daysLate = java.time.temporal.ChronoUnit.DAYS.between(issuedDate, LocalDate.now());
        int fine = daysLate > 7 ? (int)((daysLate - 7) * 2) : 0;

        log("Returned Book: " + bookId + " | Fine: ₹" + fine);
        System.out.println("Book returned. Fine: ₹" + fine);
    }

    // method: Show inventory
    public void showInventory() {
        for (Book b : books.values())
            System.out.println(b);
    }

    // method: log file
    private void log(String message) {
        try (FileWriter fw = new FileWriter("library_log.txt", true)) {
            fw.write(LocalDate.now() + " - " + message + "\n");
        } catch (IOException e) {
            System.out.println("Error writing log file.");
        }
    }
}

// class: Main
public class LibraryManagementSystem {
    public static void main(String[] args) {

        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Library Menu =====");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Show Inventory");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int ch = sc.nextInt();
            sc.nextLine();

            try {
                switch (ch) {
                    case 1:
                        System.out.print("Book ID: ");
                        String bId = sc.nextLine();
                        System.out.print("Title: ");
                        String title = sc.nextLine();
                        System.out.print("Author: ");
                        String author = sc.nextLine();
                        library.addBook(new Book(bId, title, author));
                        System.out.println("Book Added!");
                        break;

                    case 2:
                        System.out.print("Member ID: ");
                        String mId = sc.nextLine();
                        System.out.print("Name: ");
                        String name = sc.nextLine();
                        library.addMember(new Member(mId, name));
                        System.out.println("Member Added!");
                        break;

                    case 3:
                        System.out.print("Book ID: ");
                        String issueBook = sc.nextLine();
                        System.out.print("Member ID: ");
                        String issueMember = sc.nextLine();
                        library.issueBook(issueBook, issueMember);
                        System.out.println("Book Issued!");
                        break;

                    case 4:
                        System.out.print("Book ID: ");
                        String returnBook = sc.nextLine();
                        System.out.print("Member ID: ");
                        String returnMember = sc.nextLine();
                        library.returnBook(returnBook, returnMember);
                        break;

                    case 5:
                        library.showInventory();
                        break;

                    case 6:
                        System.out.println("Exiting...");
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice.");
                }
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
