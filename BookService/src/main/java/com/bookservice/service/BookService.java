package com.bookservice.service;

import com.bookservice.model.Book;
import com.bookservice.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class BookService
{

    @Autowired
    private BookRepo bookRepo;


    public ResponseEntity<?> listAllBooks()
    {
        List<Book> bookList = new ArrayList<>();
       bookList=  bookRepo.findAll();
       return  new ResponseEntity<>(bookList, HttpStatus.OK);
    }

    public ResponseEntity<?> addBook(Book book)
    {
        Book newBook = bookRepo.save(book);
        return new ResponseEntity<>(newBook,HttpStatus.OK);

    }


    public ResponseEntity<?> editBook(int id, Book book)
    {
        Optional<Book> isExisted = bookRepo.findById(id);
        if(isExisted.isPresent())
        {
            Book edit = isExisted.get();
            edit.setName(book.getName());
            edit.setAuthorName(book.getAuthorName());
            edit.setPublisher(book.getPublisher());
            edit.setPages(book.getPages());
            edit.setPrice(book.getPrice());
            edit.setReleaseYear(book.getReleaseYear());
            edit.setISBN(book.getISBN());

            bookRepo.save(edit);
            return new ResponseEntity<>(edit, HttpStatus.OK);
        }
        else
            return ResponseEntity.badRequest().body("Not Found");
    }

    public ResponseEntity<?> deleteBook(int id)
    {
        Optional<Book> isExisted = bookRepo.findById(id);
        if (isExisted.isPresent())
        {
            bookRepo.delete(isExisted.get());
            return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
        }
        else
            return ResponseEntity.badRequest().body("Not found");
    }

    public ResponseEntity<?> getBookById(int id)
    {
        Optional<Book> isExisted = bookRepo.findById(id);
        if (isExisted.isPresent())
        {
            Book getBook = isExisted.get();
            return new ResponseEntity<>(getBook, HttpStatus.OK);
        }

        else return ResponseEntity.badRequest().body("Not found");
    }

    public ResponseEntity<?> getBookByName(String name)
    {
        List<Book> bookList = bookRepo.findBookByNameContainingIgnoreCase(name);

            return new ResponseEntity<>(bookList,HttpStatus.OK);


    }

    public ResponseEntity<?> getBookByISBN(String isbn)
    {
        Optional<Book> book = bookRepo.findBookByISBN(isbn);
        if (book.isPresent())
        {
            return new ResponseEntity<>(book.get(),HttpStatus.OK);
        }
        else return ResponseEntity.badRequest().body("Not found");
    }

    public ResponseEntity<?> listBooksByAuthor(String authorName)
    {
        List<Book> bookList = new ArrayList<>();
        bookList = bookRepo.findAllByAuthorNameIsContainingIgnoreCase(authorName);
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }
}
