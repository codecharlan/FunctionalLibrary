package com.codecharlan.booklibrary;

import com.codecharlan.booklibrary.enums.Gender;
import com.codecharlan.booklibrary.enums.Role;
import com.codecharlan.booklibrary.model.BookRequest;
import com.codecharlan.booklibrary.model.Librarian;
import com.codecharlan.booklibrary.model.Students;
import com.codecharlan.booklibrary.model.Teacher;
import com.codecharlan.booklibrary.repository.Book;
import com.codecharlan.booklibrary.repository.Library;
import com.codecharlan.booklibrary.service.serviceImpl.StudentImpl;
import com.codecharlan.booklibrary.service.serviceImpl.TeacherImpl;
import com.codecharlan.booklibrary.subclass.Date;
import com.codecharlan.booklibrary.subclass.LibraryCard;

public class BookLibraryApplication {

    public static void main(String[] args) {
        Date date = new Date(22, 05, 1997);
        Date employeeHireDate = new Date(27, 04, 1996);
        Date studentTakeBookDate = new Date(12, 03, 2023);
        Date studentReturnBookDate = new Date(02, 04, 2023);
        Date teacherTakeBookDate = new Date(15, 05, 2023);
        Date teacherReturnBookDate = new Date(3, 06, 2023);
        LibraryCard studentCard = new LibraryCard("DecaSchool", "Adaoma", "A12345", "rtobe@gmail.com", "07034567890", studentTakeBookDate, studentReturnBookDate);
        LibraryCard ssstudentCard = new LibraryCard("DecaSchool", "Obioma", "A12785", "togile@gmail.com", "07037890890", studentTakeBookDate, studentReturnBookDate);
        LibraryCard teacherCard = new LibraryCard("DecaSchool", "Ifeoma", "A67890", "ifyone@gmail.com", "07034466772", teacherTakeBookDate, teacherReturnBookDate);
        Book book = Book.getInstance();
        Students seniorStudent = new Students(ssstudentCard, Role.SENIOR_STUDENT, Gender.FEMALE);
        Students juniorStudent = new Students(studentCard, Role.JUNIOR_STUDENT, Gender.MALE);
        Teacher teacher = new Teacher("Bose","AS5654", "08094563263", "no 22, Portland Rd",new Date(23,04,1993),employeeHireDate, teacherCard, Role.TEACHER, Gender.FEMALE);
        Librarian librarian = new Librarian("Tommy", "R345678", "08086754356", "No 3, AnchorWay", new Date(4, 6, 1997), new Date(5, 7, 2023));
        StudentImpl studentimpl = new StudentImpl();
        TeacherImpl teacherimpl = new TeacherImpl();
        Library library = Library.getInstance();
        BookRequest bookRequest = new BookRequest(book);

        System.out.println("                                     ");
        System.out.println(".......Before Adding Books ..........");
        System.out.println("                                     ");

        System.out.println(library.getBooksAvailable());
        System.out.println(library.getBooksAvailable().size());
        System.out.println(library.getBooksAvailable().values());


        System.out.println("                                     ");
        System.out.println(".......Adding Books ...........");
        System.out.println("                                     ");

        System.out.println(librarian.addBook(new Book("Intro to Java", "J.J. Abu", "Amazon Publiser", 000 - 4562, "Programming"), 2, Role.LIBRARIAN));

        System.out.println(library.getBooksAvailable());
        System.out.println(library.getBooksAvailable().size());
        System.out.println(library.getBooksAvailable().values());

        System.out.println(librarian.addBook(new Book("Basic principle of Learning", "A.J. Kin", "Amazon Publiser", 000 - 4902, "Education"), 4, Role.LIBRARIAN));
        System.out.println(library.getBooksAvailable());
        System.out.println(library.getBooksAvailable().size());
        System.out.println(library.getBooksAvailable().values());

        System.out.println(librarian.addBook(book, 10, Role.LIBRARIAN));

        System.out.println(library.getBooksAvailable());
        System.out.println(library.getBooksAvailable().size());
        System.out.println(library.getBooksAvailable().values());

        System.out.println("                                     ");
        System.out.println(".......For Priority Queue ...........");
        System.out.println("                                     ");

        System.out.println(library.getBooksAvailable());
        System.out.println(library.getBooksAvailable().size());
        System.out.println(library.getBooksAvailable().values());

        System.out.println(".......Books taken away from library after request ...........");
        System.out.println(studentimpl.priorityRequestBook(studentCard, book, Role.JUNIOR_STUDENT));
        System.out.println(studentimpl.priorityRequestBook(studentCard, book, Role.SENIOR_STUDENT));
        System.out.println(teacherimpl.priorityRequestBook(teacherCard, book, Role.TEACHER));
        System.out.println(studentimpl.priorityRequestBook(studentCard, book, Role.SENIOR_STUDENT));
        System.out.println(studentimpl.priorityRequestBook(studentCard, book, Role.JUNIOR_STUDENT));





        System.out.println("..Get it first ..taken away from queue");
        System.out.println(librarian.givePriorityBook(Role.LIBRARIAN));

        System.out.println("..Get it second ..taken away from queue");
        System.out.println(librarian.givePriorityBook(Role.LIBRARIAN));

        System.out.println("..Get it third ..taken away from queue");
        System.out.println(librarian.givePriorityBook(Role.LIBRARIAN));
        System.out.println(librarian.givePriorityBook(Role.LIBRARIAN));
        System.out.println(librarian.givePriorityBook(Role.LIBRARIAN));


        System.out.println(library.getBooksAvailable());
        System.out.println(library.getBooksAvailable().size());

        System.out.println(".......Books Remaining in Library before FIFO...........");
        System.out.println(library.getBooksAvailable().values());


        System.out.println("                                     ");
        System.out.println(".......For Queue (FIFO)...........");
        System.out.println("                                     ");

        System.out.println(".......Empty Queue + Books Remaining in Library...........");
        System.out.println(bookRequest.getQueue());
        System.out.println(bookRequest.getQueue().size());
        System.out.println(library.getBooksAvailable().values());

        System.out.println(studentimpl.queueRequestBook(studentCard, new Book("Basic principle of Learning", "A.J. Kin", "Amazon Publiser", 000 - 4902, "Education"), Role.JUNIOR_STUDENT));  // junior student

        System.out.println(".......Taken away from the library after request...........");
        System.out.println("                                     ");

        System.out.println(bookRequest.getQueue());
        System.out.println(bookRequest.getQueue().size());
        System.out.println(library.getBooksAvailable().values());

        System.out.println(teacherimpl.queueRequestBook(teacherCard, new Book("Intro to Java", "J.J. Abu", "Amazon Publiser", 000 - 4562, "Programming"), Role.TEACHER));

        System.out.println(bookRequest.getQueue());
        System.out.println(bookRequest.getQueue().size());
        System.out.println(library.getBooksAvailable().values());

        System.out.println(studentimpl.queueRequestBook(studentCard, book, Role.SENIOR_STUDENT));  // senior student

        System.out.println(bookRequest.getQueue());
        System.out.println(bookRequest.getQueue().size());
        System.out.println(library.getBooksAvailable().values());


        System.out.println("                                                   ");
        System.out.println("....... Response Message from Librarian .....Taken away from the queue after disbursal......");

        System.out.println(librarian.giveQueueBook(new Book("Basic principle of Learning", "A.J. Kin", "Amazon Publiser", 000 - 4902, "Education")));
        System.out.println(librarian.giveQueueBook(new Book("Intro to Java", "J.J. Abu", "Amazon Publiser", 000 - 4562, "Programming")));
        System.out.println(librarian.giveQueueBook(new Book("Intro to Java", "J.J. Abu", "Amazon Publiser", 000 - 4562, "Programming")));

        System.out.println("                                     ");
        System.out.println("....... Queue Empty ...........");

        System.out.println(bookRequest.getQueue());
        System.out.println(bookRequest.getQueue().size());

        System.out.println("....... Remaining book in the library ...........");
        System.out.println(library.getBooksAvailable().values());

    }

}
