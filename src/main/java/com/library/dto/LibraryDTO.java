/*
 * 
 */
package com.library.dto;
import lombok.Data;

/**
 * The Class LibraryDTO.
 */
@Data
public class LibraryDTO {
	
	/** The library id. */
	private long libId;
	
	/** The library name. */
	private String libName;
	
	/** The address. */
	private String address;
	
	/** The phoneNumber */
	private String phoneNumber;
	
}
