package com.booklab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booklab.model.Book;
@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

}
