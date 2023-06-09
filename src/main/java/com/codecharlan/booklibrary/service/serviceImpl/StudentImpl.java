package com.codecharlan.booklibrary.service.serviceImpl;

import com.codecharlan.booklibrary.enums.Role;
import com.codecharlan.booklibrary.model.BookRequest;
import com.codecharlan.booklibrary.repository.Book;
import com.codecharlan.booklibrary.repository.Library;
import com.codecharlan.booklibrary.service.PriorityQueueRequest;
import com.codecharlan.booklibrary.service.QueueRequest;
import com.codecharlan.booklibrary.subclass.LibraryCard;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class StudentImpl implements PriorityQueueRequest, QueueRequest {
    Library library = Library.getInstance();
    LibraryCard seniorStudent = LibraryCard.getInstance();
    Book book = Book.getInstance();
    BookRequest bookRequest = BookRequest.getInstance();


    public String priorityRequestBook(LibraryCard studentCard, Book book, Role role) {
        if (library.getBooksAvailable().containsKey(String.valueOf(book)) && library.getBooksAvailable().get(String.valueOf(book)) > 0) {
            switch (role) {
                case SENIOR_STUDENT -> bookRequest.getPriorityQueue().offer((new BookRequest(Role.SENIOR_STUDENT, 2)));
                case JUNIOR_STUDENT -> bookRequest.getPriorityQueue().offer((new BookRequest(Role.JUNIOR_STUDENT, 3)));
            }
            library.getBooksAvailable().put(String.valueOf(book), library.getBooksAvailable().get(String.valueOf(book)) - 1);

        } else {
            return book + " is not available";
        }
        if(role.equals(Role.JUNIOR_STUDENT)) {
            return book.getBookTitle() + " has been requested by " + studentCard.getName() + " who is a : " + role;
        } else {
            return book.getBookTitle() + " has been requested by " + seniorStudent.getName() + " who is a : " + role;
        }
    }

    @Override
    public String queueRequestBook(LibraryCard studentCard, Book bookTitle, Role role) {
        if (library.getBooksAvailable().containsKey(String.valueOf(bookTitle)) && library.getBooksAvailable().get(String.valueOf(bookTitle)) > 0) {
            switch (role) {
                case SENIOR_STUDENT -> bookRequest.getQueue().offer(Role.SENIOR_STUDENT);
                case JUNIOR_STUDENT -> bookRequest.getQueue().offer(Role.JUNIOR_STUDENT);
            }
            library.getBooksAvailable().put(String.valueOf(bookTitle), library.getBooksAvailable().get(String.valueOf(bookTitle)) - 1);

        } else {
            return bookTitle + " is not available";
        }
        if(role.equals(Role.JUNIOR_STUDENT)) {
            return bookTitle.getBookTitle() + " has been requested by " + studentCard.getName() + " who is a : " + role;
        } else {
            return bookTitle.getBookTitle() + " has been requested by " + seniorStudent.getName() + " who is a : " + role;
        }
    }



    @Override
    public String toString() {
        return "StudentImpl{" +
                "library=" + library +
                ", book=" + book +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentImpl student)) return false;
        return Objects.equals(library, student.library) && Objects.equals(book, student.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(library, book);
    }


}


