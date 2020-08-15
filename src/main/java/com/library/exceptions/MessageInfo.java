/*
 * 
 */
package com.library.exceptions;

/**
 * The Class MessageInfo.
 */
public class MessageInfo {

	/** The status. */
	private String status;
	
	/** The message. */
	private String message;
	
	/** The id. */
	private String id;

	/**
	 * Instantiates a new message info.
	 *
	 * @param status the status
	 * @param message the message
	 */
	public MessageInfo(String status, String message) {
		this.status = status;
		this.message = message;
	}

	/**
	 * Instantiates a new message info.
	 *
	 * @param status the status
	 * @param message the message
	 * @param id the id
	 */
	public MessageInfo(String status, String message, String id) {
		// TODO Auto-generated constructor stub
		this.status = status;
		this.message = message;
		this.id = id;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

//Getters and setters are omitted

}