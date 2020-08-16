/*
 * 
 */
package com.library.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;

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
	 @NonNull
	private  String status;
	
	/** The message. */
	 @NonNull
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
