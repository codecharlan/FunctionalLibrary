package com.codecharlan.booklibrary;

import com.codecharlan.booklibrary.enums.Role;
import com.codecharlan.booklibrary.model.BookRequest;
import com.codecharlan.booklibrary.model.Librarian;
import com.codecharlan.booklibrary.repository.Book;
import com.codecharlan.booklibrary.repository.Library;
import com.codecharlan.booklibrary.service.serviceImpl.StudentImpl;
import com.codecharlan.booklibrary.service.serviceImpl.TeacherImpl;
import com.codecharlan.booklibrary.subclass.Date;
import com.codecharlan.booklibrary.subclass.LibraryCard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class LibrarianTest {
    Library library;
    Book book;
    Librarian librarian;
    StudentImpl studentimpl;
    LibraryCard studentCard;
    Role role;
    LibraryCard teacherCard;
    Date teacherTakeBookDate;
    Date teacherReturnBookDate;
    Date  studentTakeBookDate;
    Date studentReturnBookDate;
    TeacherImpl teacherimpl;
    BookRequest bookRequest;
    @BeforeEach
    void setUp() {
        studentimpl = new StudentImpl();
        teacherimpl = new TeacherImpl();
        library = Library.getInstance();
        book = Book.getInstance();
        bookRequest = BookRequest.getInstance();
        library = Library.getInstance();
        book = Book.getInstance();
        studentTakeBookDate = new Date(12, 03, 2023);
        studentReturnBookDate = new Date(02, 04, 2023);
        teacherTakeBookDate = new Date(15, 05, 2023);
        teacherReturnBookDate = new Date(3, 06, 2023);
        librarian = new Librarian("Tommy", "R345678", "08086754356", "No 3, AnchorWay", new Date(4, 6, 1997), new Date(5, 7, 2023));
        studentCard = new LibraryCard("DecaSchool", "Adaoma", "A12345", "rtobe@gmail.com", "07034567890", studentTakeBookDate, studentReturnBookDate);
        teacherCard = new LibraryCard("DecaSchool", "Ifeoma", "A67890", "ifyone@gmail.com", "07034466772", teacherTakeBookDate, teacherReturnBookDate);
        librarian.addBook(book, 7, Role.LIBRARIAN);
        teacherimpl.priorityRequestBook(teacherCard, book, Role.TEACHER);
        studentimpl.priorityRequestBook(studentCard, book, Role.SENIOR_STUDENT);
        teacherimpl.queueRequestBook(teacherCard, book, Role.TEACHER);

    }

    @Test
    void addBook() {
        String expected = book + " has been added to the Library";
        String actual = librarian.addBook(book, 17, Role.LIBRARIAN);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expected, actual);
        Assertions.assertTrue(library.getBooksAvailable().containsKey(String.valueOf(book)));
        Assertions.assertTrue(library.getBooksAvailable().get(String.valueOf(book)) > 0);
        Assertions.assertEquals(library.getBooksAvailable().size(), 1);
        Assertions.assertEquals(library.getBooksAvailable().get(String.valueOf(book)), 17);
    }

    @Test
    void givePriorityBook() {
    Assertions.assertFalse(bookRequest.getPriorityQueue().isEmpty());
    }


    @Test
    void giveQueueBook() {
        Assertions.assertFalse(bookRequest.getQueue().isEmpty());
    }
}