package com.bookservice.repository;

import com.bookservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepo extends JpaRepository<Book,Integer>
{
    List<Book> findBookByNameContainingIgnoreCase(String name);
    Optional<Book> findBookByISBN(String isbn);

    List<Book> findAllByAuthorNameIsContainingIgnoreCase(String authorName);
}
