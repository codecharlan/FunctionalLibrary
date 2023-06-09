package com.codecharlan.booklibrary.repository;

import com.codecharlan.booklibrary.enums.Role;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Library {
    private Map<String, Integer> booksAvailable;
    public static Library instance;

    public static Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
    }

    public Library() {
        this.booksAvailable = new HashMap<>();
    }

    public Map<String, Integer> getBooksAvailable() {
        return booksAvailable;
    }

    public void setBooksAvailable(Map<String, Integer> booksAvailable) {
        this.booksAvailable = booksAvailable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Library library)) return false;
        return getBooksAvailable().equals(library.getBooksAvailable());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBooksAvailable());
    }

    @Override
    public String toString() {
        return "Library{" +
                "booksAvailable=" + booksAvailable +
                '}';
    }
}
