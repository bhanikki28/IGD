package com.anz.bookstore.controller;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.anz.bookstore.model.Book;
import com.anz.bookstore.service.BookStoreService;

@ExtendWith(MockitoExtension.class)
class BookStoreControllerTest {

	public List<Book> booksList = new ArrayList<>();
	
	private static final String BOOK1_NAME="Associate GCP Cloud Engineer";
	private static final String BOOK2_NAME="Associate GCP Data Engineer";
	private static final String BOOK3_NAME="GCP in Action";
	private static final String AUTHOR_NAME="Dan Sullivan";
	private static final String IN_STOCK="yes";
	private static final String PUBLISHED_DATE="2020-11-05";





	@Mock
	BookStoreService mockService;

	@InjectMocks
	BookStoreController bookStoreController;

	Book book1, book2,book3;
	
	@BeforeEach
	void setUp() {
		book1 = new Book(1,BOOK1_NAME, AUTHOR_NAME, LocalDate.parse(PUBLISHED_DATE), 54.00, IN_STOCK);
		book2 = new Book(2, BOOK2_NAME, AUTHOR_NAME, LocalDate.parse(PUBLISHED_DATE), 64.00, IN_STOCK);
		book3 = new Book(3,BOOK3_NAME,AUTHOR_NAME,LocalDate.parse(PUBLISHED_DATE),54.00,IN_STOCK);
		booksList.add(book1);
		booksList.add(book2);
		booksList.add(book3);

	}

	
	@Test
	public void testGetAllBooks() {
		when(mockService.getBooks()).thenReturn(booksList);
		assertEquals(3, bookStoreController.getAllBooks("").size());
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
		assertEquals(BOOK2_NAME, bookStoreController.getBookById("2").getBookName());
	}
	
	
	@Test
	public void saveBook()
	{
		Book newBook = new Book(3,BOOK3_NAME,AUTHOR_NAME,LocalDate.parse(PUBLISHED_DATE),54.00,IN_STOCK);
		when(mockService.saveBook(newBook)).thenReturn(newBook);
		assertEquals(BOOK3_NAME, bookStoreController.addBook(newBook).getBookName());
	}
	

}

