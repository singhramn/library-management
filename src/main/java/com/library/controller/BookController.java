/*
 * 
 */
package com.library.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.validator.routines.ISBNValidator;
import org.hibernate.HibernateException;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.library.constants.AppConstants;
import com.library.constants.RequestMappingConstants;
import com.library.dto.BookDTO;
import com.library.dto.ResponseDetails;
import com.library.entity.Book;
import com.library.exceptions.LibraryException;
import com.library.service.BookService;
import com.library.utils.ObjectMapperUtils;

/**
 * The Book Controller for managing the books in library.
 */
@RestController
@RequestMapping(value = RequestMappingConstants.BOOK_CONTROLLER)
public class BookController {

	/** The Constant LOGGER. */
	 static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);

	/** The book service. */
	@Autowired
	private BookService bookService;

	/**
	 * Adds the book.
	 *
	 * @param bookto the book dto
	 * @return the response entity
	 * @throws LibraryException the library exception
	 */
	@PostMapping(value = RequestMappingConstants.ADD_BOOK)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResponseEntity<?> addBook(@RequestBody BookDTO bookto) throws LibraryException {
		LOGGER.info("addBook execution starts");
		ResponseDetails responseDetails = new ResponseDetails();
		String isbn = bookto.getIsbn();
		BookDTO resBook = null;
		try {
			if (null != isbn) {
				ISBNValidator validator = new ISBNValidator();
				if (validator.isValid(bookto.getIsbn())) {
					resBook = ObjectMapperUtils.map((bookService.addBook(ObjectMapperUtils.map(bookto, Book.class))),
							BookDTO.class);
					responseDetails.setMessageId(Long.toString(resBook.getBookId()));
					responseDetails.setMessage("Book Added successfully");
				} else {
					throw new LibraryException(isbn, ": getMessage Starts: " + AppConstants.ISBN_NOT_FOUND);
				}
			}
		} catch (ConstraintViolationException e) {
			throw new LibraryException(AppConstants.DATABASE_EXCEPTION,
					"getCause: " + e.getCause() + " :  getMessage Starts:  " + e.getMessage());
		} catch (Exception e) {
			throw new LibraryException(AppConstants.EXCEPTION,
					"getCause: " + e.getCause() + ": getMessage Starts: " + e.getMessage());

		}
		LOGGER.info("addBook execution end");
		return new ResponseEntity<ResponseDetails>(responseDetails, HttpStatus.OK);
	}

	/**
	 * Update books.
	 *
	 * @param bookDto the book dto
	 * @return the response entity
	 * @throws LibraryException the library exception
	 */
	@ResponseStatus(HttpStatus.CREATED)
	@PutMapping(value = RequestMappingConstants.UPDATE_BOOK_DETAILS)
	@ResponseBody
	public ResponseEntity<?> updateBookDetails(@RequestBody BookDTO bookDto) throws LibraryException {
		LOGGER.info("updateBook execution start");
		ResponseDetails responseDetails = new ResponseDetails();
		try {
			BookDTO resBook = ObjectMapperUtils
					.map((bookService.updateBook(ObjectMapperUtils.map(bookDto, Book.class))), BookDTO.class);
			responseDetails.setMessageId(Long.toString(resBook.getBookId()));
			responseDetails.setMessage("Book Updated successfully");
		} catch (ConstraintViolationException e) {
			throw new LibraryException(AppConstants.DATABASE_EXCEPTION,
					"getCause: " + e.getCause() + " :  getMessage Starts:  " + e.getMessage());
		}

		catch (Exception e) {
			throw new LibraryException(AppConstants.EXCEPTION,
					"getCause: " + e.getCause() + ": getMessage Starts: " + e.getMessage());

		}
		LOGGER.info("updateBook execution end");
		return new ResponseEntity<ResponseDetails>(responseDetails, HttpStatus.OK);
	}

	/**
	 * Delete book.
	 *
	 * @param id the id
	 * @return the response entity
	 * @throws LibraryException the library exception
	 */
	@DeleteMapping(value = RequestMappingConstants.DELETE_BOOK)
	public ResponseEntity<?> deleteBook(@PathVariable("book_id") Long id) throws LibraryException {
		LOGGER.info("deleteBook execution start");
		ResponseDetails responseDetails = new ResponseDetails();
		try {
			if (bookService.deleteBookById(id)) {
				responseDetails.setMessageId(Long.toString(id));
				responseDetails.setMessage("Book Deleted Sucessfully");
			} else {
				responseDetails.setMessage("Unable to delete book, book is checked out already.");
			}
		} catch (HibernateException e) {
			throw new LibraryException(AppConstants.DATABASE_EXCEPTION,
					"getCause: " + e.getCause() + " :  getMessage Starts:  " + e.getMessage());
		} catch (Exception e) {
			throw new LibraryException(AppConstants.EXCEPTION,
					"getCause: " + e.getCause() + ": getMessage Starts: " + e.getMessage());

		}
		LOGGER.info("deleteBook execution end");
		return new ResponseEntity<ResponseDetails>(responseDetails, HttpStatus.OK);
	}

	/**
	 * List books.
	 *
	 * @return the list
	 * @throws LibraryException the library exception
	 */
	@GetMapping(value = RequestMappingConstants.LIST_BOOKS)
	public @ResponseBody List<BookDTO> listBooks() throws LibraryException {
		LOGGER.info("listBooks execution start");
		List<BookDTO> booksList = new ArrayList<>();

		try {
			List<Book> books = bookService.findAll();
			for (Book book : books) {
				BookDTO bookdto = new BookDTO();
				bookdto.setTitle(book.getTitle());
				bookdto.setAuthor(book.getAuthor());
				bookdto.setBookId(book.getBookId());
				bookdto.setNumOfCopies(book.getNumOfCopies());
				bookdto.setPublisher(book.getPublisher());
				bookdto.setYearOfPublication(book.getYearOfPublication());
				bookdto.setIsbn(book.getIsbn());
				booksList.add(bookdto);
			}
		} catch (HibernateException e) {
			throw new LibraryException(AppConstants.DATABASE_EXCEPTION,
					"getCause: " + e.getCause() + " :  getMessage Starts:  " + e.getMessage());
		} catch (Exception e) {
			throw new LibraryException(AppConstants.EXCEPTION,
					"getCause: " + e.getCause() + ": getMessage Starts: " + e.getMessage());

		}
		LOGGER.info("listBooks execution end");
		return booksList;
	}

	/**
	 * Search book by isbn.
	 *
	 * @param isbn the isbn
	 * @return the response entity
	 * @throws LibraryException the library exception
	 */
	@GetMapping(value = RequestMappingConstants.SEARCH_BOOK_BY_ISBN)
	public ResponseEntity<?> searchBookByIsbn(@PathVariable("isbn") String isbn) throws LibraryException {
		LOGGER.info("searchBookByIsbn execution start");
		BookDTO bookDto = ObjectMapperUtils.map(bookService.getBookByISBN(isbn), BookDTO.class);

		try {
			if (null == bookDto) {
				throw new LibraryException(isbn, ": getMessage Starts: " + AppConstants.ISBN_NOT_FOUND);
			}
		} catch (HibernateException e) {
			throw new LibraryException(AppConstants.DATABASE_EXCEPTION,
					"getCause: " + e.getCause() + " :  getMessage Starts:  " + e.getMessage());
		}
		LOGGER.info("searchBookByIsbn execution end");
		return new ResponseEntity<BookDTO>(bookDto, HttpStatus.OK);
	}

	/**
	 * Borrow book by isbn.
	 *
	 * @param isbn    the isbn
	 * @param user_id the user id
	 * @return the response entity
	 * @throws LibraryException the library exception
	 */
	@GetMapping(value = RequestMappingConstants.BORROW_BOOK_REQUEST)
	public ResponseEntity<?> borrowBookByIsbn(@PathVariable("isbn") String isbn, @PathVariable("user_id") Long user_id)
			throws LibraryException {
		LOGGER.info("borrowBookByIsbn execution start");
		BookDTO bookDto = ObjectMapperUtils.map(bookService.getBookByISBN(isbn), BookDTO.class);
		try {
			if (null == bookDto) {
				throw new LibraryException(isbn, ": getMessage Starts: " + AppConstants.ISBN_NOT_FOUND);
			} else {
				// TODO: Save borrow request Data
			}
		} catch (HibernateException e) {
			throw new LibraryException(AppConstants.DATABASE_EXCEPTION,
					"getCause: " + e.getCause() + " :  getMessage Starts:  " + e.getMessage());
		}
		LOGGER.info("borrowBookByIsbn execution end");
		return new ResponseEntity<BookDTO>(bookDto, HttpStatus.OK);
	}

	/**
	 * Cancel borrow request.
	 *
	 * @param isbn    the isbn
	 * @param user_id the user id
	 * @return the response entity
	 * @throws LibraryException the library exception
	 */
	@GetMapping(value = RequestMappingConstants.CANCEL_BORROW_BOOK_REQUEST)
	public ResponseEntity<?> cancelBorrowRequest(@PathVariable("isbn") String isbn,
			@PathVariable("user_id") Long user_id) throws LibraryException {
		LOGGER.info("cancelBorrowRequest execution start");
		BookDTO bookDto = ObjectMapperUtils.map(bookService.getBookByISBN(isbn), BookDTO.class);
		try {
			if (null == bookDto) {
				throw new LibraryException(isbn, ": getMessage Starts: " + AppConstants.ISBN_NOT_FOUND);
			} else {
				// TODO: Remove Request

			}
		} catch (HibernateException e) {
			throw new LibraryException(AppConstants.DATABASE_EXCEPTION,
					"getCause: " + e.getCause() + " :  getMessage Starts:  " + e.getMessage());
		}
		LOGGER.info("cancelBorrowRequest execution end");
		return new ResponseEntity<BookDTO>(bookDto, HttpStatus.OK);
	}

	/**
	 * Search book by ID.
	 *
	 * @param id the id
	 * @return the response entity
	 * @throws LibraryException the library exception
	 */
	@GetMapping(value = RequestMappingConstants.SEARCH_BOOK_BY_ID)
	public ResponseEntity<?> searchBookById(@PathVariable("book_id") Long id) throws LibraryException {
		LOGGER.info("searchBookByID executions start");
		BookDTO bookDto = null;
		try {
			Optional<Book> res_book = bookService.findBookById(id);
			bookDto = ObjectMapperUtils.map(res_book.get(), BookDTO.class);
		} catch (HibernateException e) {
			throw new LibraryException(AppConstants.DATABASE_EXCEPTION,
					"getCause: " + e.getCause() + " :  getMessage Starts:  " + e.getMessage());
		} catch (Exception e) {
			throw new LibraryException(AppConstants.DATABASE_EXCEPTION,
					"getCause: " + e.getCause() + ": getMessage Starts: " + e.getMessage());

		}
		LOGGER.info("searchBookByID execution end");
		return new ResponseEntity<BookDTO>(bookDto, HttpStatus.OK);
	}

}
