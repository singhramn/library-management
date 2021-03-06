/*
 * 
 */
package com.library.dto;
import lombok.Data;
/**
 * The Class UserDTO.
 */
@Data
public class UserDTO {
	
	/** The user id. */
	private long userId;
	
	/** The user name. */
	private String userName;
	
	/** The email. */
	private String email;
	
	/** The address. */
	private String address;
	
	/** The phone Number. */
	private String phoneNumber;
	
	/** The role id. */
	private String roleId;

}
