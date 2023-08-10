package com.bookservice.controller;

import com.bookservice.model.Book;
import com.bookservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookservice")
public class BookController
{
    @Autowired
    private BookService service;


    @GetMapping("/all")
    public ResponseEntity<?> getAllBooks()
    {
        return  service.listAllBooks();
    }

    @PostMapping
    public ResponseEntity<?> addBook(@RequestBody Book book)
    {
        return service.addBook(book);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> editBook(@PathVariable int id, @RequestBody Book book)
    {
        return service.editBook(id, book);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable int id)
    {
       return service.deleteBook(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable int id)
    {
        return service.getBookById(id);
    }
    @GetMapping("/byname")
    public ResponseEntity<?> getBookByName(@RequestParam String name)
    {
        return service.getBookByName(name);
    }
    @GetMapping("/byisbn")
    public ResponseEntity<?> getBookByISBN(@RequestParam String isbn)
    {
        return service.getBookByISBN(isbn);
    }
    @GetMapping("/byauthor")
    public ResponseEntity<?> getBooksOfAuthor(@RequestParam String authorName)
    {
        return service.listBooksByAuthor(authorName);
    }
}