/*
 * 
 */
package com.library.service;

import com.library.entity.User;
import java.util.List;

/**
 * The Interface UserService.
 */
public interface UserService {

	/**
	 * Adds the user.
	 *
	 * @param user the user
	 * @return the user
	 */
	public User addUser(User user);
	
	/**
	 * List users.
	 *
	 * @return the list
	 */
	public List<User> listUsers();
	
	/**
	 * Find user.
	 *
	 * @param id the id
	 * @return the user
	 */
	public User findUser(Long id);
	
	/**
	 * Find user by email.
	 *
	 * @param usermail the usermail
	 * @return the user
	 */
	public User findUserByEmail(String usermail);
	
	/**
	 * Update user details.
	 *
	 * @param user the user
	 * @return the user
	 */
	public User updateUserDetails(User user);
	
	/**
	 * Change password.
	 *
	 * @param user the user
	 * @return the user
	 */
	public User changePassword(User user);
	
	/**
	 * Update role.
	 *
	 * @param user the user
	 * @return the user
	 */
	public User updateRole(User user);
	
	/**
	 * Delete user by id.
	 *
	 * @param id the id
	 * @return true, if successful
	 */
	public boolean deleteUserById(Long id);
	
	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public List<User> findAll() ;
	
	
}
