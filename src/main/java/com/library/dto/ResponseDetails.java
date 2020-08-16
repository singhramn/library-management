/*
 * 
 */
package com.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class ResponseDetails.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDetails {

	/** The id. */
	private String messageId;
	
	/** The status. */
	private  String status;
	
	/** The message. */
	private String message;
	
	 
	 /**
		 * Instantiates a new ResponseDetails.
		 *
		 * @param status the status
		 * @param message the message
		 */
		public ResponseDetails(String status, String message) {
			this.status = status;
			this.message = message;
		}
	
}
