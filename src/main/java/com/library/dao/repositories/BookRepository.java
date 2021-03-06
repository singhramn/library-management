/*
 * 
 */
package com.library.dao.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.library.entity.Book;

/**
 * The Interface BookRepository.
 */
public interface BookRepository extends JpaRepository<Book, Long> {
    
    /**
     * Find by isbn.
     *
     * @param isbn the isbn
     * @return the list
     */
    public List<Book> findByIsbn(String isbn);
    
    /**
     * Delete by isbn.
     *
     * @param isbn the isbn
     * @return the list
     */
    public boolean deleteBookByIsbn(String isbn);
    
}