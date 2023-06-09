package com.codecharlan.booklibrary.repository;

import com.codecharlan.booklibrary.enums.Role;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Book {
    private String bookTitle;
    private String author;
    private String publisher;
    private Integer ISBN;
    private String category;


    public static Book instance;

    public Book() {

    }

    public static Book getInstance() {
        if (instance == null) {
            instance = new Book("Properties of Matter", "A.A.Juliet", "J.J Thaut Ltd", 000 - 2345, "Science");
        }
        return instance;
    }


    public Book(String bookTitle, String author, String publisher, Integer ISBN, String category) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.publisher = publisher;
        this.ISBN = ISBN;
        this.category = category;
    }



    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookTitle() {
        return bookTitle;
    }


    @Override
    public String toString() {
        return "Book{" +
                "bookTitle='" + bookTitle + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", ISBN=" + ISBN +
                ", category='" + category + '\'' +
                '}';
    }
}
