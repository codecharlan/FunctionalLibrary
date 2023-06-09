package com.codecharlan.booklibrary.service;

import com.codecharlan.booklibrary.enums.Role;
import com.codecharlan.booklibrary.repository.Book;
import com.codecharlan.booklibrary.subclass.LibraryCard;

public interface QueueRequest {
    String queueRequestBook(LibraryCard libraryCard, Book bookTitle, Role role);
}
