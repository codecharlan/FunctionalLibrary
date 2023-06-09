package com.codecharlan.booklibrary.service;

import com.codecharlan.booklibrary.model.Librarian;
import com.codecharlan.booklibrary.enums.Role;
import com.codecharlan.booklibrary.repository.Book;
import com.codecharlan.booklibrary.repository.Library;
import com.codecharlan.booklibrary.service.serviceImpl.StudentImpl;
import com.codecharlan.booklibrary.subclass.Date;
import com.codecharlan.booklibrary.subclass.LibraryCard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TeacherImplTest {
    StudentImpl studentimpl;
    Date  studentTakeBookDate;
    Date studentReturnBookDate;
    Library library;
    Book book;
    LibraryCard studentCard;
    Role role;
    LibraryCard teacherCard;
    Date teacherTakeBookDate;
    Date teacherReturnBookDate;
    Librarian librarian;

    @BeforeEach
    void setUp() {
        studentimpl = new StudentImpl();
        library = Library.getInstance();
        book = Book.getInstance();
        studentTakeBookDate = new Date(12, 03, 2023);
        studentReturnBookDate = new Date(02, 04, 2023);
        teacherTakeBookDate = new Date(15, 05, 2023);
        teacherReturnBookDate = new Date(3, 06, 2023);
        studentCard = new LibraryCard("DecaSchool", "Adaoma", "A12345", "rtobe@gmail.com", "07034567890", studentTakeBookDate, studentReturnBookDate);
        teacherCard = new LibraryCard("DecaSchool", "Ifeoma", "A67890", "ifyone@gmail.com", "07034466772", teacherTakeBookDate, teacherReturnBookDate);
        librarian = new Librarian("Tommy", "R345678", "08086754356", "No 3, AnchorWay", new Date(4, 6, 1997), new Date(5, 7, 2023));
        librarian.addBook(book, 7, Role.LIBRARIAN);
    }

    @Test
    void priorityRequestBook() {
        String actual = studentimpl.priorityRequestBook(teacherCard, book, Role.TEACHER);
        String expected = book + " has been requested by " + teacherCard + " who is a : " + Role.TEACHER;
        boolean value = library.getBooksAvailable().values().toString() != null;
        Assertions.assertNotNull(actual);
        Assertions.assertTrue(value);
        Assertions.assertEquals(expected, actual);
        Assertions.assertTrue(library.getBooksAvailable().containsKey(String.valueOf(book)));
        Assertions.assertTrue(library.getBooksAvailable().get(String.valueOf(book)) > 0);
        Assertions.assertEquals(library.getBooksAvailable().get(String.valueOf(book)), 6);
    }

    @Test
    void queueRequestBook() {
        String actual = studentimpl.queueRequestBook(teacherCard, book, Role.SENIOR_STUDENT);
        String expected = book + " has been requested by " + teacherCard + " who is a : " + Role.SENIOR_STUDENT;
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expected, actual);
        Assertions.assertTrue(library.getBooksAvailable().containsKey(String.valueOf(book)));
        Assertions.assertTrue(library.getBooksAvailable().get(String.valueOf(book)) > 0);
        Assertions.assertEquals(library.getBooksAvailable().get(String.valueOf(book)), 6);
    }
}