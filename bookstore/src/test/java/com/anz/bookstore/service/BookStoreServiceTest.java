package com.anz.bookstore.service;

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
import com.anz.bookstore.repository.BookStoreRepository;

@ExtendWith(MockitoExtension.class)
class BookStoreServiceTest {
	
	public List<Book> booksList = new ArrayList<>();

	
	@Mock
	BookStoreRepository mockRepo;
	
	@InjectMocks
	BookStoreService mockService;

	Book book1,book2;
	
	@BeforeEach
	void setUp() {
        book1 = new Book(1,"GCP Cloud Engineer","Dan Sullivan",LocalDate.parse("2020-11-05"),54.00,"yes");
        book2 = new Book(2,"GCP Data Engineer","Dan Sullivan",LocalDate.parse("2021-11-05"),64.00,"yes");
        booksList.add(book1);
        booksList.add(book2);
	}
	
	@Test
	public void getAllBooks()
	{
		
        when(mockRepo.findAll()).thenReturn(booksList);
		assertEquals(2, mockService.getBooks().size());
		
	}
	
	@Test
	public void getBookById()
	{
	    when(mockRepo.getById(Integer.parseInt("2"))).thenReturn(book2);
		assertEquals("GCP Data Engineer", mockService.getBookById("2").getBookName());
	}
	
	@Test
	public void saveBook()
	{
		Book newBook = new Book(3,"GCP in Action","Dan Sullinan",LocalDate.parse("2020-11-05"),54.00,"yes");
		when(mockRepo.save(newBook)).thenReturn(newBook);
		assertEquals("GCP in Action", mockService.saveBook(newBook).getBookName());
	}
	

}
