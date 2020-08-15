package com.library.service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.library.dao.repositories.BookRepository;
import com.library.entity.Book;


public class BookServiceTest {

	public static final String ISBN = "978-3-16-148410-0";
	public static final String BOOK_TITLE = "Java";
	public static final long BOOK_ID = 1;
	public static final String AUTHOR = "Ram N";
	public static final String PUBLISHER = "A-Press";

	@InjectMocks
	private BookServiceImpl bookService;

	@Mock
	private BookRepository bookRepository;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		List<Book> books = new ArrayList<>();
		books.add(getBookEntity());
		when(bookRepository.getOne(BOOK_ID)).thenReturn(getBookEntity());
		when(bookService.addBook(getBookEntity())).thenReturn(getBookEntity());
		when(bookService.updateBook(getBookEntity())).thenReturn(getBookEntity());
		when(bookService.listBooks()).thenReturn(books);
	}

	@Test
	public void addBookTest() {
		Book bookResult = bookService.addBook(getBookEntity());
		Assert.assertEquals(ISBN, bookResult.getIsbn());
		Assert.assertEquals(BOOK_TITLE, bookResult.getTitle());
		Assert.assertEquals(AUTHOR, bookResult.getAuthor());
		Assert.assertEquals(PUBLISHER, bookResult.getPublisher());
	}

	@Test
	public void updateBookTest() {

		Book bookResult = bookService.updateBook(getBookEntity());
		Assert.assertEquals(ISBN, bookResult.getIsbn());
		Assert.assertEquals(BOOK_TITLE, bookResult.getTitle());
		Assert.assertEquals(AUTHOR, bookResult.getAuthor());
		Assert.assertEquals(PUBLISHER, bookResult.getPublisher());
	}

	@Test
	public void listBooksTest() {
		List<Book> booksActual = bookService.listBooks();
		Assert.assertEquals(1, booksActual.size());
		Assert.assertEquals(ISBN, booksActual.get(0).getIsbn());
		Assert.assertEquals(BOOK_TITLE, booksActual.get(0).getTitle());
		Assert.assertEquals(AUTHOR, booksActual.get(0).getAuthor());
		Assert.assertEquals(PUBLISHER, booksActual.get(0).getPublisher());
	}

	@Test
	public void deleteBookTest() {
		boolean deleteResult = bookService.deleteBookByIsbn(ISBN);
		Assert.assertTrue(deleteResult);
	}

	public Book getBookEntity() {
		Book book = new Book();
		book.setAuthor(AUTHOR);
		book.setBookId(1);
		book.setLibId(1);
		book.setIsbn(ISBN);
		book.setNumOfCopies(1);
		book.setPublisher(PUBLISHER);
		book.setTitle(BOOK_TITLE);
		book.setYearOfPublication("2020");
		return book;
	}
}
