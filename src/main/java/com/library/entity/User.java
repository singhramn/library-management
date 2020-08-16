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
 * The Class User.
 */
@Entity
@Table(name = "USER")
@Data
public class User {

	/** The user id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", length = 8, unique = true, nullable = false)
	private long userId;
	
	/** The user name. */
	@Column(name = "NAME", nullable = false)
	private String userName;
	
	/** The email. */
	@Column(name = "EMAIL", nullable = false)
	private String email;
	
	/** The address. */
	@Column(name = "ADDRESS", nullable = false)
	private String address;
	
	/** The phone Number. */
	@Column(name = "PHONE_NUMBER", nullable = false)
	private String phoneNumber;
	
	/** The role id. */
	@Column(name = "roleId", nullable = false)
	private String roleId;
		
}
