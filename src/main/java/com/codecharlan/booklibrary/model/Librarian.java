package com.codecharlan.booklibrary.model;

import com.codecharlan.booklibrary.enums.Role;
import com.codecharlan.booklibrary.model.Employee;
import com.codecharlan.booklibrary.repository.Book;
import com.codecharlan.booklibrary.repository.Library;
import com.codecharlan.booklibrary.subclass.Date;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Librarian extends Employee {
    Library library = Library.getInstance();
    BookRequest bookRequest = BookRequest.getInstance();
    Book book = Book.getInstance();

    public Librarian(String employeeName, String employeeId, String employeePhoneNumber, String employeeAddress, Date employeeDateOfBirth, Date employeeHireDate) {
        super(employeeName, employeeId, employeePhoneNumber, employeeAddress, employeeDateOfBirth, employeeHireDate);
    }

    public String addBook(Book bookTitle, Integer numberOfBook, Role role) {
        if (role != Role.LIBRARIAN) {
            return "You are not authorised to make this entry";
        } else {
            library.getBooksAvailable().put(String.valueOf(bookTitle), numberOfBook);
            return bookTitle + " has been added to the Library";
        }
    }
    public String givePriorityBook(Role role) {
        if (role == Role.LIBRARIAN) {
            if (bookRequest.getPriorityQueue().isEmpty()) {
                return "No books requested";
            }
            BookRequest getRequestFromTheQueue = bookRequest.getPriorityQueue().poll();
            Role roleOfPersonInQueue = getRequestFromTheQueue.getRole();

            if (roleOfPersonInQueue.equals(Role.TEACHER)) {
                bookRequest.getPriorityQueue().remove(Role.TEACHER);
                return book + " taken by a Teacher";
            }

            if (roleOfPersonInQueue.equals(Role.SENIOR_STUDENT)) {
                bookRequest.getPriorityQueue().remove(Role.SENIOR_STUDENT);
                return book + " taken by a Senior Student";
            }

            if (roleOfPersonInQueue.equals(Role.JUNIOR_STUDENT)) {
                bookRequest.getPriorityQueue().remove(Role.JUNIOR_STUDENT);
                return book + "taken by a Junior Student";
            }

            return "No books requested";
        } else {
            return " You are not authorised to give out books";
        }
    }
    public String giveQueueBook(Book bookRequested) {
        if (bookRequest.getQueue().isEmpty()) {
            return "No books requested";
        }

        Optional<Role> firstRole = bookRequest.getQueue().stream().findFirst();
        if (firstRole.isPresent()) {
            Role role = firstRole.get();
            bookRequest.getQueue().removeIf(r -> r.equals(role));
            return bookRequested.getBookTitle() + " taken by " + role.toString();
        }

        return "No books requested";
    }

    @Override
    public String toString() {
        return "Librarian{" +
                "library=" + library +
                ", book=" + book +
                "} " + super.toString();
    }
}
