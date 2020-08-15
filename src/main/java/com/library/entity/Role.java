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
 * The Class ROLE.
 */
@Entity
@Table(name = "ROLE")
@Data
public class Role {

	/** The role id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", length = 8, unique = true, nullable = false)
	private long roleId;

	/** The role name. */
	@Column(name = "NAME", nullable = false)
	private String roleName;

	/** The description. */
	@Column(name = "DESCRIPTION", nullable = false)
	private String description;

}
