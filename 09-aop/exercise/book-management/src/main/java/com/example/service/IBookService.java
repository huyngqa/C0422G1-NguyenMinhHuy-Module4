package com.example.service;

import com.example.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAllBook();

    Book findBookById(String id);

    void saveBook(Book book);
}
