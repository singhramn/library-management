/*
 * 
 */
package com.library.exceptions;

/**
 * The Class LibraryException.
 */
public class LibraryException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2859292084648724403L;
	
	/** The error code. */
	private final String errorCode;

	/** The parameter list. */
	String parameterList;

	/**
	 * Instantiates a new library exception.
	 *
	 * @param errorCode the error code
	 * @param parameterList the parameter list
	 */
	public LibraryException(String errorCode, String parameterList) {
		super(errorCode);
		this.errorCode = errorCode;
		this.parameterList = parameterList;
	}

	/**
	 * Gets the parameter list.
	 *
	 * @return the parameter list
	 */
	public String getParameterList() {
		return parameterList;
	}

	/**
	 * Sets the parameter list.
	 *
	 * @param parameterList the new parameter list
	 */
	public void setParameterList(String parameterList) {
		this.parameterList = parameterList;
	}

	public String getErrorCode() {
		return errorCode;
	}

}
