/*
 * 
 */
package com.library.dao.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.library.entity.Library;

/**
 * The Interface LibraryRepository.
 */
public interface LibraryRepository extends JpaRepository<Library, Long> {
	
	/**
	 * Find all.
	 *
	 * @return the list
	 */
	List<Library> findAll();
}