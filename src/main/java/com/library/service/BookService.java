/**
 * 
 */
package com.library.service;

import java.util.List;
import java.util.Optional;

import com.library.entity.Book;

/**
 * The Interface BookService.
 */
public interface BookService {
    
   /**
    * List books.
    *
    * @return the list
    */
   List<Book> listBooks();
   
   /**
    * Find book by id.
    *
    * @param bookId the book id
    * @return the optional
    */
   Optional<Book> findBookById(Long bookId);
   
   /**
    * Delete book by id.
    *
    * @param id the id
    * @return true, if successful
    */
   boolean deleteBookById(Long id);
   
   
   /**
    * Delete book by isbn.
    *
    * @param id the id
    * @return true, if successful
    */
   boolean deleteBookByIsbn(String isbn);
   
   
   /**
    * Update books.
    *
    * @param updatedbook the updatedbook
    * @return the book
    */
   Book updateBook(Book updatedbook);
   
   /**
    * Gets the available book count.
    *
    * @return the available book count
    */
   int getAvailableBookCount();
   
   /**
    * Gets the book by ISBN.
    *
    * @param isbn the isbn
    * @return the book by ISBN
    */
   Book getBookByISBN(String isbn);
   
   /**
    * Adds the book.
    *
    * @param book the book
    * @return the book
    */
   Book addBook(Book book);
   
   /**
    * Find all.
    *
    * @return the list
    */
   List<Book> findAll();

  
}
