/*
 * 
 */
package com.library.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.dao.repositories.LibraryRepository;
import com.library.entity.Library;

/**
 * The Class LibraryServiceImpl.
 */
@Service
public class LibraryServiceImpl implements LibraryService {
	
	/** The library repository. */
	@Autowired
	private LibraryRepository libraryRepository;

	/**
	 * Adds the library.
	 *
	 * @param Library the library
	 * @return the library
	 */
	@Override
	@Transactional
	public Library addLibrary(Library Library) {
		return libraryRepository.save(Library);
	}
   
   /**
    * List libraries.
    *
    * @return the list
    */
   @Override
    public List<Library> listLibraries() {
        return libraryRepository.findAll();
    }

    /**
     * Find library.
     *
     * @param id the id
     * @return the library
     */
    @Override
    public Library findLibrary(Long id) {
        return libraryRepository.findById(id).get();
    }

   
    /**
     * Update library details.
     *
     * @param Library the library
     * @return the library
     */
    @Override
    @Transactional
    public Library updateLibraryDetails(Library Library) {
    	Library LibraryToUpdate = libraryRepository.getOne(Library.getLibId());
		LibraryToUpdate.setAddress(Library.getAddress());
		LibraryToUpdate.setPhoneNumber(Library.getPhoneNumber());
		return libraryRepository.save(LibraryToUpdate);
       
    }
    
    /**
     * Delete library by id.
     *
     * @param id the id
     * @return true, if successful
     */
    @Override
	@Transactional
	public boolean deleteLibraryById(Long id) {
   	libraryRepository.deleteById(id);
		return true;
	}
    
   
 
}
