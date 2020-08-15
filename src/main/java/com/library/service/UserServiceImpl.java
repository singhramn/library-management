/*
 * 
 */
package com.library.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.dao.repositories.UserRepository;
import com.library.entity.User;

/**
 * The Class UserServiceImpl.
 */
@Service
public class UserServiceImpl implements UserService {
	
	/** The user repository. */
	@Autowired
	private UserRepository userRepository;

	/**
	 * Adds the user.
	 *
	 * @param User the user
	 * @return the user
	 */
	@Override
	@Transactional
	public User addUser(User User) {
		return userRepository.save(User);
	}
   
   /**
    * List users.
    *
    * @return the list
    */
   @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    /**
     * Find user.
     *
     * @param id the id
     * @return the user
     */
    @Override
    public User findUser(Long id) {
        return userRepository.findById(id).get();
    }

    /**
     * Update user details.
     *
     * @param user the user
     * @return the user
     */
    @Override
    public User updateUserDetails(User user) {
    	User userToUpdate = userRepository.getOne(user.getUserId());
		userToUpdate.setAddress(user.getAddress());
		userToUpdate.setPhoneNumber(user.getPhoneNumber());
		return userRepository.save(userToUpdate);
       
    }
    
    /**
     * Change password.
     *
     * @param user the user
     * @return the user
     */
    @Override
    public User changePassword(User user) {
    	User userToUpdate = userRepository.getOne(user.getUserId());
		userToUpdate.setPassword(user.getPassword());
		return userRepository.save(userToUpdate);
       
    }
   
    /**
     * Update role.
     *
     * @param user the user
     * @return the user
     */
    @Override
    public User updateRole(User user) {
    	User userToUpdate = userRepository.getOne(user.getUserId());
		userToUpdate.setRoleId(user.getPassword());
		return userRepository.save(userToUpdate);
   }

   /**
    * Find user by email.
    *
    * @param usermail the usermail
    * @return the user
    */
   @Override
    public User findUserByEmail(String usermail) {
	   List<User> user = userRepository.findUserByEmail(usermail);
        return user.get(0);
    }
   
   /**
    * Delete user by id.
    *
    * @param id the id
    * @return true, if successful
    */
   @Override
   @Transactional
	public boolean deleteUserById(Long id) {
	   userRepository.deleteById(id);
		return true;
	}
   
   /**
	 * Find all.
	 *
	 * @return the list
	 */
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}
   
}
