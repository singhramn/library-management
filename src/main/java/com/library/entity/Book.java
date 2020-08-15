/*
 * 
 */
package com.library.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 * The Class Book.
 */
@Entity
@Table(name = "BOOK")
@Data
public class Book {

	/** The book id. */
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "BOOK_ID", length = 8, unique = true, nullable = false)
	private long bookId;
	
	
	/** The isbn. */
	@Column(name = "ISBN", nullable = false, unique = true)
	private String isbn;
	
	/** The title. */
	@Column(name = "TITLE", nullable = false)
	private String title;


	/** The author. */
	@Column(name = "AUTHOR", nullable = false)
	private String author;


	/** The publisher. */
	@Column(name = "PUBLISHER", nullable = false)
	private String publisher;

	/** The year of publication. */
	@Column(name = "YEAR_OF_PUBLICATION")
	private String yearOfPublication;

	/** The num of copies. */
	@Column(name = "NUM_OF_COPIES")
	private int numOfCopies;

	/** The image. */
	@Column(name = "IMAGE")
	private byte[] image;

	/** The last available date. */
	@Column(name = "LAST_AVAILABLE_DATE")
	private String last_available_date;
	
	/** The current status. */
	@Column(name = "Current_Status")
	private String currentStatus;
	
	/** The isbn. */
	@Column(name = "Lib_Id", nullable = false, unique = true)
	private long libId;


}
