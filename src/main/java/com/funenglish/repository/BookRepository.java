package com.funenglish.repository;

import com.funenglish.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByLevel(String level);
    List<Book> findByAuthor(String author);
} 