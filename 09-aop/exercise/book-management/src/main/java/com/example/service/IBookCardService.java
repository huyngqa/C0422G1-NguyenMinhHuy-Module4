package com.example.service;

import com.example.model.BookCard;

public interface IBookCardService {
    void saveBookCard(BookCard bookCard);

    void deleteById(int id);

    BookCard getById(int id);
}
