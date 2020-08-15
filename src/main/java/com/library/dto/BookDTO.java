/*
 * 
 */
package com.library.dto;

import lombok.Data;

/**
 * The Class BookDTO.
 */
@Data
public class BookDTO {

	/** The book id. */
	private long bookId;

	/** The isbn. */
	private String isbn;

	/** The title. */

	private String title;
	/** The author. */

	private String author;

	/** The publisher. */
	private String publisher;

	/** The year of publication. */
	private String yearOfPublication;

	/** The number of copies. */
	private int numOfCopies;

	/** The image. */
	private byte[] image;

	/** The last available date. */
	private String lastAvailableDate;

	/** The current status. */
	private String currentStatus;

	/** The lib id. */
	private long libId;
}
