/*
 * 
 */
package com.library.dao.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.library.entity.User;

/**
 * The Interface UserRepository.
 */
public interface UserRepository extends JpaRepository<User, Long> {

	/**
	 * Find user by email.
	 *
	 * @param email the email
	 * @return the list
	 */
	public List<User> findUserByEmail(String email);

}