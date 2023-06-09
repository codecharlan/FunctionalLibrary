package com.codecharlan.booklibrary.model;

import com.codecharlan.booklibrary.enums.Gender;
import com.codecharlan.booklibrary.enums.Role;
import com.codecharlan.booklibrary.subclass.Date;
import com.codecharlan.booklibrary.subclass.LibraryCard;

public class Teacher extends Employee{
    private LibraryCard teacherCard;
    private Role staff;
    private Gender gender;

    public Teacher(String employeeName, String employeeId, String employeePhoneNumber, String employeeAddress, Date employeeDateOfBirth, Date employeeHireDate, LibraryCard teacherCard, Role staff, Gender gender) {
        super(employeeName, employeeId, employeePhoneNumber, employeeAddress, employeeDateOfBirth, employeeHireDate);
        this.teacherCard = teacherCard;
        this.staff = staff;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherCard=" + teacherCard +
                ", staff=" + staff +
                ", gender=" + gender +
                "} " + super.toString();
    }
}
