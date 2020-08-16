/**
 *
 */
package com.library.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.dao.repositories.BookRepository;
import com.library.entity.Book;
import com.library.service.BookService;

/**
 * The Class BookServiceImpl.
 */
@Service
public class BookServiceImpl implements BookService {

	/** The book repository. */
	@Autowired
	private BookRepository bookRepository;

	/**
	 * Adds the book.
	 *
	 * @param book the book
	 * @return the book
	 */
	@Override
	@Transactional
	public Book addBook(Book book) {
		return bookRepository.save(book);
	}

	/**
	 * Update books.
	 *
	 * @param updatedbook the updatedbook
	 * @return the book
	 */
	@Override
	@Transactional
	public Book updateBook(Book updatedbook) {

		Book bookToUpdate = bookRepository.getOne(updatedbook.getBookId());
		bookToUpdate.setAuthor(updatedbook.getAuthor());
		bookToUpdate.setIsbn(updatedbook.getIsbn());
		bookToUpdate.setNumOfCopies(updatedbook.getNumOfCopies());
		bookToUpdate.setImage(updatedbook.getImage());
		bookToUpdate.setPublisher(updatedbook.getPublisher());
		bookToUpdate.setTitle(updatedbook.getTitle());
		bookToUpdate.setCurrentStatus(updatedbook.getCurrentStatus());
		return bookRepository.save(bookToUpdate);
	}

	/**
	 * Delete book by id.
	 *
	 * @param id the id
	 * @return true, if successful
	 */
	@Override
	@Transactional
	public boolean deleteBookById(Long id) {
		bookRepository.deleteById(id);
		return true;
	}

	/**
	 * Delete book by id.
	 *
	 * @param id the id
	 * @return true, if successful
	 */
	@Override
	@Transactional
	public boolean deleteBookByIsbn(String isbn) {
		/* A book cannot be deleted if it’s checked out by a patron. */
		bookRepository.deleteBookByIsbn(isbn);
		return true;
	}

	/**
	 * List books.
	 *
	 * @return the list
	 */
	@Override
	public List<Book> listBooks() {
		return bookRepository.findAll();
	}

	/**
	 * Find book by id.
	 *
	 * @param bookId the book id
	 * @return the optional
	 */
	@Override
	public Optional<Book> findBookById(Long bookId) {
		return bookRepository.findById(bookId);
	}

	/**
	 * Gets the book by ISBN.
	 *
	 * @param isbn the isbn
	 * @return the book by ISBN
	 */
	@Override
	public Book getBookByISBN(String isbn) {
		List<Book> books = bookRepository.findByIsbn(isbn);
		return books.get(0);
	}

	/**
	 * Gets the available book count.
	 *
	 * @return the available book count
	 */
	@Override
	public int getAvailableBookCount() {
		return bookRepository.findAll().size();
	}

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	@Override
	public List<Book> findAll() {
		return bookRepository.findAll();
	}

}
