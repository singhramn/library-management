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
 * The Class Library.
 */
@Entity
@Table(name = "LIBRARY")
@Data
public class Library {
	
	/** The library id. */
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "LIBRARY_ID", length = 8, unique = true, nullable = false)
	private long libId;

	/** The library name. */
	@Column(name = "LIBRARY_NAME", nullable = false, unique = true)
	private String libName;

	/** The address. */
	@Column(name = "ADDRESS", nullable = false)
	private String address;
	
	/** The phone Number. */
	@Column(name = "PHONE_NUMBER", nullable = false)
	private String phoneNumber;

}
