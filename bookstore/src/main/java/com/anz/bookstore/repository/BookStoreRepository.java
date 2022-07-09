package com.anz.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anz.bookstore.model.Book;

@Repository
public interface BookStoreRepository extends JpaRepository<Book, Integer> {
	

}