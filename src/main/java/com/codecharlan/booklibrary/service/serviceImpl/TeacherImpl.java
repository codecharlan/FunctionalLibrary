package com.codecharlan.booklibrary.service.serviceImpl;

import com.codecharlan.booklibrary.enums.Role;
import com.codecharlan.booklibrary.model.BookRequest;
import com.codecharlan.booklibrary.repository.Book;
import com.codecharlan.booklibrary.repository.Library;
import com.codecharlan.booklibrary.service.PriorityQueueRequest;
import com.codecharlan.booklibrary.service.QueueRequest;
import com.codecharlan.booklibrary.subclass.LibraryCard;

import java.util.Map;

public class TeacherImpl implements PriorityQueueRequest, QueueRequest {
    Library library = Library.getInstance();
    BookRequest bookRequest = BookRequest.getInstance();
    Book book = Book.getInstance();

    @Override
    public String priorityRequestBook(LibraryCard teacherCard, Book book, Role role) {
        if (library.getBooksAvailable().containsKey(String.valueOf(book)) && library.getBooksAvailable().get(String.valueOf(book)) > 0) {
            bookRequest.getPriorityQueue().offer(new BookRequest(Role.TEACHER, 1));
            library.getBooksAvailable().compute(String.valueOf(book), (key, value) -> value - 1);
        } else {
            return book + " is not available";
        }

        return book.getBookTitle() + " has been requested by " + teacherCard.getName() + " who is a : " + role;
    }

    @Override
    public String queueRequestBook(LibraryCard teacherCard, Book bookTitle, Role role) {
        boolean bookAvailable = library.getBooksAvailable()
                .entrySet()
                .stream()
                .filter(entry -> entry.getKey().equals(String.valueOf(bookTitle)))
                .mapToInt(Map.Entry::getValue)
                .anyMatch(count -> count > 0);

        if (bookAvailable) {
            if (role == Role.TEACHER) {
                bookRequest.getQueue().offer(Role.TEACHER);
            }
            library.getBooksAvailable()
                    .computeIfPresent(String.valueOf(bookTitle), (key, value) -> value - 1);
        } else {
            return bookTitle + " is not available";
        }

        return bookTitle.getBookTitle() + " has been requested by " + teacherCard.getName() + " who is a: " + role;
    }

    @Override
    public String toString() {
        return "TeacherImpl{" +
                "library=" + library +
                ", book=" + book +
                '}';
    }

}

