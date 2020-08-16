/*
 * 
 */
package com.library.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.entity.Library;

/**
 * The Interface LibraryRepository.
 */
public interface LibraryRepository extends JpaRepository<Library, Long> {
	// TODO: Method which are not available in default will be defined here
}