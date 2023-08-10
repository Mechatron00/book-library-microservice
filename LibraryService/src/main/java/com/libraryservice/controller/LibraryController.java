package com.libraryservice.controller;

import com.libraryservice.repository.BookServiceInterface;
import org.bouncycastle.asn1.ocsp.ResponderID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("library")
public class LibraryController
{
    @Autowired
    private BookServiceInterface service;

    @GetMapping("/all")
    public ResponseEntity<?> GetAllBooks()
    {
        return service.getAllBooks();
    }
    @GetMapping("bookbyid/{id}")
    public ResponseEntity<?> GetBookById(@PathVariable int id)
    {
        return service.getBookById(id);
    }
    @GetMapping("/bookbyname")
    public ResponseEntity<?> listBooksByName(@RequestParam String name)
    {
       return service.getBookByName(name);
    }
    @GetMapping("/booksByAuthor")
    public ResponseEntity<?> getBooksOfAuthor(@RequestParam String name)
    {
        return service.getBooksOfAuthor(name);
    }
    @GetMapping("/byisbn")
    public ResponseEntity<?> getBookByISBN(@RequestParam String isbn)
    {
        return service.getBookByISBN(isbn);
    }

}
