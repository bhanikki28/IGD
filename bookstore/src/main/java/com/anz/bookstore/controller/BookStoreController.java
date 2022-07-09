package com.anz.bookstore.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anz.bookstore.exception.BookNotFoundException;
import com.anz.bookstore.model.Book;
import com.anz.bookstore.service.BookStoreService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/v1/books")
@Api(value = "BookStore Management", protocols = "http")
public class BookStoreController {

	@Autowired
	private BookStoreService service;

	@ApiOperation(value = "To retrieve all books ", response = Book.class, code = 200)
	@GetMapping
	public List<Book> getAllBooks(@RequestParam(required = false) String name) {
		if (name == null || name.length() == 0) {
			return service.getBooks();
		}

		return service.getBooks().stream().filter(book -> book.getBookName().matches(name + "(.*)"))
				.collect(Collectors.toList());

	}

	@ApiOperation(value = "To retrieve particular book by passing the  id", response = Book.class, code = 200)
	@GetMapping("/{id}")
	public Book getBookById(@PathVariable String id) {

		return service.getBookById(id);

	}

	@PostMapping
	@ApiOperation(value = "To create a book by passing the id,name,author,price and inStock", response = Book.class, code = 200)
	public Book addBook(@RequestBody Book book) {
		return service.saveBook(book);
	}

}