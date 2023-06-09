package com.codecharlan.booklibrary.subclass;

import com.codecharlan.booklibrary.enums.Gender;
import com.codecharlan.booklibrary.enums.Role;
import com.codecharlan.booklibrary.model.BookRequest;
import com.codecharlan.booklibrary.model.Students;

public class LibraryCard {
    private final String schoolName;
    private String name;
    private String idNumber;
    private String emailAddress;
    private String phoneNumber;
    private Date takenBook;
    private Date returnBook;

    public static LibraryCard instance;

    public static LibraryCard getInstance() {
        if (instance == null) {
            instance = new LibraryCard("DecaSchool", "Obioma", "A12785", "togile@gmail.com", "07037890890", new Date(4,8,2023), new Date(9, 10, 2023));
        }
        return instance;
    }

    public LibraryCard(String schoolName, String name, String idNumber, String emailAddress, String phoneNumber, Date takenBook, Date returnBook) {
        this.schoolName = schoolName;
        this.name = name;
        this.idNumber = idNumber;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.takenBook = takenBook;
        this.returnBook = returnBook;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getTakenBook() {
        return takenBook;
    }

    public void setTakenBook(Date takenBook) {
        this.takenBook = takenBook;
    }

    public Date getReturnBook() {
        return returnBook;
    }

    public void setReturnBook(Date returnBook) {
        this.returnBook = returnBook;
    }

    @Override
    public String toString() {
        return "LibraryCard{" +
                "schoolName='" + schoolName + '\'' +
                ", name='" + name + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", takenBook=" + takenBook +
                ", returnBook=" + returnBook +
                '}';
    }
}
