package com.project3.librarymangement.repository;

import com.project3.librarymangement.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {

}
