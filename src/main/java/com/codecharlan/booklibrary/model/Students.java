package com.codecharlan.booklibrary.model;

import com.codecharlan.booklibrary.enums.Gender;
import com.codecharlan.booklibrary.enums.Role;
import com.codecharlan.booklibrary.subclass.LibraryCard;

public class Students {
    private LibraryCard studentCard;
    private Role studentClass;
    private Gender gender;

    public Students(LibraryCard studentCard, Role studentClass, Gender gender) {
        this.studentCard = studentCard;
        this.studentClass = studentClass;
        this.gender = gender;
    }

}
