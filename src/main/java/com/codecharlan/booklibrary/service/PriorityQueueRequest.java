package com.codecharlan.booklibrary.service;

import com.codecharlan.booklibrary.enums.Role;
import com.codecharlan.booklibrary.repository.Book;
import com.codecharlan.booklibrary.subclass.LibraryCard;

public interface PriorityQueueRequest {
    String priorityRequestBook(LibraryCard libraryCard, Book book, Role role);
}
