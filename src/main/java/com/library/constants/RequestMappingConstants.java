/*
 * 
 */
package com.library.constants;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The Class RequestMappingConstants.
 */
public class RequestMappingConstants {

	/**
	 * Instantiates a new request mapping constants.
	 */
	private RequestMappingConstants() {
	}

	/**
	 * This block provides constants for {@link RequestMapping} urls related to
	 * {@link bookController}.
	 */
	public static final String BOOK_CONTROLLER = "/book";
	
	/** The Constant ADD_BOOK. */
	public static final String ADD_BOOK = "/addbook";
	
	/** The Constant UPDATE_BOOK_DETAILS. */
	public static final String UPDATE_BOOK_DETAILS = "/updatebook";
	
	/** The Constant DELETE_BOOK. */
	public static final String DELETE_BOOK = "/deletebook/{book_id}";
	
	/** The Constant SEARCH_BOOK_BY_ID. */
	public static final String SEARCH_BOOK_BY_ID = "/bookid/{book_id}";
	
	/** The Constant SEARCH_BOOK_BY_ISBN. */
	public static final String SEARCH_BOOK_BY_ISBN = "/isbn/{isbn}";
	
	
	/**  The Constant BORROW_BOOK_REQUEST. */
	public static final String BORROW_BOOK_REQUEST = "/borrowbook/{isbn}/{user_id}";
	
	/**  The Constant CANCEL_BORROW_BOOK_REQUEST. */
	public static final String CANCEL_BORROW_BOOK_REQUEST = "/cancleborrowbook/{isbn}/{user_id}";
	
	
	
	/** The Constant LIST_BOOKS. */
	public static final String LIST_BOOKS = "/listBooks";

	/**
	 * This block provides constants for {@link RequestMapping} urls related to
	 * {@link UserController}.
	 */
	public static final String USER_CONTROLLER = "/user";
	
	/** The Constant ADD_USER. */
	public static final String ADD_USER = "/adduser";
	
	/** The Constant UPDATE_USER. */
	public static final String UPDATE_USER = "/updateuser";
	
	/** The Constant DELETE_USER. */
	public static final String DELETE_USER = "/deleteuser/{user_id}";
	
	/** The Constant ASSIGN_ROLE. */
	public static final String ASSIGN_ROLE = "/assignrole";
	
	/** The Constant CHANGE_PASSWORD. */
	public static final String CHANGE_PASSWORD = "/changePassword";
	
	/** The Constant UPDATE_ROLE. */
	public static final String UPDATE_ROLE = "/updaterole";
	
	/** The Constant DELETE_USER. */
	public static final String LIST_USER = "/listusers";


	/**
	 * This block provides constants for {@link RequestMapping} urls related to
	 * {@link LibraryController}.
	 */
	public static final String LIBRARY_CONTROLLER = "/library";
	
	/** The Constant ADD_LIBRARY. */
	public static final String ADD_LIBRARY = "/addlibrary";
	
	/** The Constant UPDATE_LIBRARY. */
	public static final String UPDATE_LIBRARY = "/updatelibrary";
	
	/** The Constant DELETE_LIBRARY. */
	public static final String DELETE_LIBRARY = "/deletelibrary/{library_id}";
	
	/** The Constant ISSUE_BOOK. */
	public static final String ISSUE_BOOK = "/issuebook/{library_id}/{user_id}/{book_id}";
	
	/** The Constant RETURN_BOOK. */
	public static final String RETURN_BOOK = "/Returnbook/{library_id}/{user_id}/{book_id}";



}
