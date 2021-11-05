package com.github.hiltonfarias.bookManager.repository;

import com.github.hiltonfarias.bookManager.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
