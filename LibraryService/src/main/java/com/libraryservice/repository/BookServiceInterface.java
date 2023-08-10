package com.libraryservice.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("BOOK-SERVICE")
public interface BookServiceInterface
{
    @GetMapping("bookservice/{id}")
    public ResponseEntity<?> getBookById(@PathVariable int id);

    @GetMapping("bookservice/byname")
    public ResponseEntity<?> getBookByName(@RequestParam String name);

    @GetMapping("bookservice/byisbn")
    public ResponseEntity<?> getBookByISBN(@RequestParam String isbn);

    @GetMapping("bookservice/byauthor")
    public ResponseEntity<?> getBooksOfAuthor(@RequestParam String authorName);

    @GetMapping("bookservice/all")
    public ResponseEntity<?> getAllBooks();

}
