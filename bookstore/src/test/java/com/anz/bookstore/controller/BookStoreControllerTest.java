package com.anz.bookstore.controller;


import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.anz.bookstore.exception.BookNotFoundException;
import com.anz.bookstore.model.Book;
import com.anz.bookstore.service.BookStoreService;

@ExtendWith(MockitoExtension.class)
class BookStoreControllerTest {

	public List<Book> booksList = new ArrayList<>();

	@Mock
	BookStoreService mockService;

	@InjectMocks
	BookStoreController bookStoreController;

	Book book1, book2;
	
	@BeforeEach
	void setUp() {
		book1 = new Book(1,"GCP Cloud Engineer", "Dan Sullinan", LocalDate.parse("2020-11-05"), 54.00, "yes");
		book2 = new Book(2, "Data Engineer", "Dan Sullinan", LocalDate.parse("2021-11-05"), 64.00, "yes");
		booksList.add(book1);
		booksList.add(book2);
	}

	
	@Test
	public void testGetAllBooks() {
		when(mockService.getBooks()).thenReturn(booksList);
		assertEquals(2, bookStoreController.getAllBooks("").size());
	}
	
	@Test
	public void testGetAllBooksByName() {
		when(mockService.getBooks()).thenReturn(booksList);
		assertEquals(1, bookStoreController.getAllBooks("GCP").size());
	}
	
	
	@Test
	public void getBookById()
	{
	    when(mockService.getBookById("2")).thenReturn(book2);
		assertEquals("Data Engineer", bookStoreController.getBookById("2").getBookName());
	}
	
	
	@Test
	public void saveBook()
	{
		Book newBook = new Book(3,"GCP in Action","Dan Sullinan",LocalDate.parse("2020-11-05"),54.00,"yes");
		when(mockService.saveBook(newBook)).thenReturn(newBook);
		assertEquals("GCP in Action", bookStoreController.addBook(newBook).getBookName());
	}
	

}

