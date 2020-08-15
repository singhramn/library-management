/*
 * 
 */
package com.library.service;

import com.library.entity.Library;
import java.util.List;

/**
 * The Interface LibraryService.
 */
public interface LibraryService {

	/**
	 * Adds the library.
	 *
	 * @param Library the library
	 * @return the library
	 */
	public Library addLibrary(Library Library);
	
	/**
	 * List libraries.
	 *
	 * @return the list
	 */
	public List<Library> listLibraries();
	
	/**
	 * Find library.
	 *
	 * @param id the id
	 * @return the library
	 */
	public Library findLibrary(Long id);
	
	/**
	 * Update library details.
	 *
	 * @param Library the library
	 * @return the library
	 */
	public Library updateLibraryDetails(Library Library);
	
	/**
	 * Delete library by id.
	 *
	 * @param id the id
	 * @return true, if successful
	 */
	public boolean deleteLibraryById(Long id);

}
