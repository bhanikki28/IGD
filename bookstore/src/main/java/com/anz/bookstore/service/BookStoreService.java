package com.anz.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anz.bookstore.model.Book;
import com.anz.bookstore.repository.BookStoreRepository;

@Service
public class BookStoreService {

	@Autowired
	private BookStoreRepository repository;

	public List<Book> getBooks() {
		return repository.findAll();
	}

	public Book getBookById(String id) {
		return repository.getById(Integer.parseInt(id));
	}

	public Book saveBook(Book book) {
		return repository.save(book);
	}

}