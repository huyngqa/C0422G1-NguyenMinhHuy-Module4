package com.example.repository;

import com.example.model.BookCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookCardRepository extends JpaRepository<BookCard, Integer> {
}
