package com.project3.librarymangement.Service;

import com.project3.librarymangement.entity.Book;
import com.project3.librarymangement.entity.User;
import com.project3.librarymangement.rest.BookNotFoundException;
import com.project3.librarymangement.rest.UserNotFoundException;
import com.project3.librarymangement.repository.BookRepository;
import com.project3.librarymangement.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
  private final BookRepository bookRepository;
  private final UserRepository userRepository;

  @Autowired
  public BookService(BookRepository bookRepository, UserRepository userRepository) {
    this.bookRepository = bookRepository;
    this.userRepository = userRepository;
  }


@Transactional
  public Book createBook(Book book) {
    if (book.getId() != null) throw new RuntimeException("The book is already exist");
    return bookRepository.save(book);
  }

  public List<Book> getBooks() {
    return bookRepository.findAll();
  }

  public Book getBook(Long id) {
    return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("The Book you want don't exist"));
  }

  @Transactional
  public void deleteBook(Long id) {
    Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("The Book you want don't exist"));
    bookRepository.delete(book);
  }

  @Transactional
  public Book borrowBook(Long id, Long userid) {
    Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("The Book you want don't exist"));
    if (book.isBorrowed()) throw new RuntimeException("The book you want is already borrowed");
    User user = userRepository.findById(userid).orElseThrow(()-> new UserNotFoundException("The user not found")) ;
    book.setBorrowedBy(user);
    book.setBorrowed(true);
    return bookRepository.save(book);
  }

  @Transactional
  public Book returnBook(Long id){
    Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("The Book you want " +
            "to return don't exist"));
    if(book.isBorrowed()){
      book.setBorrowedBy(null);
      book.setBorrowed(false);
    }
    return bookRepository.save(book);

  }
}
