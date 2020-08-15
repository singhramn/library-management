/*
 * 
 */
package com.library.controller;

import javax.servlet.http.HttpServletRequest;

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
import com.library.dto.LibraryDTO;
import com.library.dto.ResponseDetails;
import com.library.entity.Library;
import com.library.exceptions.LibraryException;
import com.library.service.LibraryService;
import com.library.utils.ObjectMapperUtils;

/**
 * The Book Controller for managing the books in library.
 */
@RestController
@RequestMapping(value = RequestMappingConstants.LIBRARY_CONTROLLER)
public class LibraryController {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(LibraryController.class);

	/** The LibraryService. */
	@Autowired
	LibraryService libraryService;

	/**
	 * Adds the library.
	 *
	 * @param libDto the lib dto
	 * @return the response entity
	 * @throws LibraryException the library exception
	 */
	@PostMapping(value = RequestMappingConstants.ADD_LIBRARY)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResponseEntity<?> addLibrary(@RequestBody LibraryDTO libDto) throws LibraryException {
		LOGGER.info("addLibrary execution starts");
		ResponseDetails responseDetails = new ResponseDetails();
		LibraryDTO resLibrary = null;
		try {
			resLibrary = ObjectMapperUtils
					.map((libraryService.addLibrary(ObjectMapperUtils.map(libDto, Library.class))), LibraryDTO.class);
			responseDetails.setMessageID(Long.toString(resLibrary.getLibId()));
			responseDetails.setMessageReason("Library Added successfully");
		} catch (Exception e) {
			throw new LibraryException(AppConstants.EXCEPTION,
					"getCause: " + e.getCause() + ": getMessage Starts: " + e.getMessage());
		}
		LOGGER.info("addLibrary execution end");
		return new ResponseEntity<ResponseDetails>(responseDetails, HttpStatus.OK);
	}

	/**
	 * Update library details.
	 *
	 * @param libraryDTO the library DTO
	 * @param request    the request
	 * @return the response entity
	 * @throws LibraryException the library exception
	 */
	@ResponseStatus(HttpStatus.CREATED)
	@PutMapping(value = RequestMappingConstants.UPDATE_LIBRARY)
	@ResponseBody
	public ResponseEntity<?> updateLibraryDetails(@RequestBody LibraryDTO libraryDTO, HttpServletRequest request)
			throws LibraryException {
		LOGGER.info("updateLibraryDetails execution start");
		ResponseDetails responseDetails = new ResponseDetails();
		try {
			LibraryDTO reslib = ObjectMapperUtils.map(
					(libraryService.updateLibraryDetails(ObjectMapperUtils.map(libraryDTO, Library.class))),
					LibraryDTO.class);
			responseDetails.setMessageID(Long.toString(reslib.getLibId()));
			responseDetails.setMessageReason("Library Updated successfully");
		} catch (Exception e) {
			throw new LibraryException(AppConstants.EXCEPTION,
					"getCause: " + e.getCause() + ": getMessage Starts: " + e.getMessage());
		}
		LOGGER.info("updateLibraryDetails execution end");
		return new ResponseEntity<ResponseDetails>(responseDetails, HttpStatus.OK);
	}

	/**
	 * Delete library.
	 *
	 * @param id the id
	 * @return the response entity
	 * @throws LibraryException the library exception
	 */
	@DeleteMapping(value = RequestMappingConstants.DELETE_LIBRARY)
	public ResponseEntity<?> deleteLibrary(@PathVariable("library_id") Long id) throws LibraryException {
		LOGGER.info("deleteLibrary execution start");
		ResponseDetails responseDetails = new ResponseDetails();

		try {
			if (libraryService.deleteLibraryById(id)) {
				responseDetails.setMessageID(Long.toString(id));
				responseDetails.setMessageReason("Library Deleted Sucessfully");
			}
		} catch (Exception e) {
			throw new LibraryException(AppConstants.EXCEPTION,
					"getCause: " + e.getCause() + ": getMessage Starts: " + e.getMessage());
		}
		LOGGER.info("deleteLibrary execution end");
		return new ResponseEntity<ResponseDetails>(responseDetails, HttpStatus.OK);
	}

	/**
	 * Issue book.
	 *
	 * @param bookDto the book dto
	 * @param id      the id
	 * @return the response entity
	 * @throws LibraryException the library exception
	 */
	@PostMapping(value = RequestMappingConstants.ISSUE_BOOK)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResponseEntity<?> issueBook(@PathVariable("library_id") Long library_id,
			@PathVariable("user_id") Long user_id, @PathVariable("book_id") Long book_id) throws LibraryException {
		LOGGER.info("IssueBook execution start");
		ResponseDetails responseDetails = new ResponseDetails();
		try {
			// TODO
		} catch (Exception e) {
			throw new LibraryException(AppConstants.EXCEPTION,
					"getCause: " + e.getCause() + ": getMessage Starts: " + e.getMessage());
		}
		LOGGER.info("IssueBook execution end");
		return new ResponseEntity<ResponseDetails>(responseDetails, HttpStatus.OK);
	}

	/**
	 * Issue book.
	 *
	 * @param book_id the book id
	 * @param user_id the user id
	 * @return the response entity
	 * @throws LibraryException the library exception
	 */
	@GetMapping(value = RequestMappingConstants.RETURN_BOOK)
	@ResponseBody
	public ResponseEntity<ResponseDetails> returnBook(@PathVariable("library_id") Long library_id,
			@PathVariable("user_id") Long user_id, @PathVariable("book_id") Long book_id) throws LibraryException {
		LOGGER.info("ReturnBook execution start");
		ResponseDetails responseDetails = new ResponseDetails();
		try {
			// TODO
		} catch (Exception e) {
			throw new LibraryException(AppConstants.EXCEPTION,
					"getCause: " + e.getCause() + ": getMessage Starts: " + e.getMessage());
		}
		LOGGER.info("ReturnBook execution end");
		return new ResponseEntity<ResponseDetails>(responseDetails, HttpStatus.OK);
	}

}
