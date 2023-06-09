package com.codecharlan.booklibrary.model;

import com.codecharlan.booklibrary.enums.Role;
import com.codecharlan.booklibrary.repository.Book;

import java.util.LinkedList;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

public class BookRequest extends Book implements Comparable<BookRequest>{
    private static Book book;
    private Queue<Role> queue;
    private PriorityQueue<BookRequest> priorityQueue;
    private Role role;
    private Integer priority;
    public static BookRequest instance;

    public static BookRequest getInstance() {
        if (instance == null) {
            instance = new BookRequest(book);;
        }
        return instance;
    }

    public BookRequest(Role role, Integer priority) {
        this.role = role;
        this.priority = priority;
    }

    public BookRequest(Book book) {
        this.book = book;
        this.queue = new LinkedList<>();
        this.priorityQueue = new PriorityQueue<>();
    }

    public BookRequest(String bookTitle, String author, String publisher, Integer ISBN, String category, Book book, Queue<Role> queue, PriorityQueue<BookRequest> priorityQueue) {
        super(bookTitle, author, publisher, ISBN, category);
        this.book = book;
        this.queue = queue;
        this.priorityQueue = priorityQueue;
    }

    public Role getRole() {
        return role;
    }

    public PriorityQueue<BookRequest> getPriorityQueue() {
        return priorityQueue;
    }

    public Queue<Role> getQueue() {
        return queue;
    }

    public void setQueue(Queue<Role> queue) {
        this.queue = queue;
    }

    @Override
    public int compareTo(BookRequest that) {
        if (this.priority != that.priority) {
            if (this.priority == 1) {
                return -1;
            } else if (that.priority == 1) {
                return 1;
            } else if (this.priority == 2) {
                return -1;
            } else if (that.priority == 2) {
                return 1;
            } else if (this.priority == 3) {
                return -1;
            } else if (that.priority == 3) {
                return 1;
            }
        }
        return Integer.compare(this.priority, that.priority);
    }
}
