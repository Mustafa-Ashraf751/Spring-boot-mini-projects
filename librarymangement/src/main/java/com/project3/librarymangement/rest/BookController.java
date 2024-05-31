package com.project3.librarymangement.rest;

import com.project3.librarymangement.Service.BookService;
import com.project3.librarymangement.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;
@Autowired
  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @PostMapping
  public Book createBook(@RequestBody Book book){
  return bookService.createBook(book);
  }

  @GetMapping
  public List<Book> getBooks(){
  return bookService.getBooks();
  }

  @GetMapping("/{id}")
  public Book getBook(@PathVariable Long id){
  return bookService.getBook(id);
  }

  @DeleteMapping("/{id}")
  public String deleteBook(@PathVariable Long id){
    bookService.deleteBook(id);
    return "The book has been deleted";
  }

  @PostMapping("/{id}/borrow/{userid}")
  public Book borrowBook(@PathVariable Long id,@PathVariable Long userid){
    return bookService.borrowBook(id,userid);
  }

  @PostMapping("/{id}/return")
  public Book returnBook(@PathVariable Long id){
    return bookService.returnBook(id);
  }
}
