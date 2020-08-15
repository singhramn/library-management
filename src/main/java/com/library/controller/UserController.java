/*
 * 
 */
package com.library.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.library.constants.AppConstants;
import com.library.constants.RequestMappingConstants;
import com.library.dto.ResponseDetails;
import com.library.dto.UserDTO;
import com.library.entity.User;
import com.library.exceptions.LibraryException;
import com.library.service.UserService;
import com.library.utils.ObjectMapperUtils;

/**
 * The User Controller for managing users with different roles.
 */
@RestController
@RequestMapping(value = RequestMappingConstants.USER_CONTROLLER)
public class UserController {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	/** The user service. */
	@Autowired
	UserService userService;

	/**
	 * Adds the user.
	 *
	 * @param userDto  the user dto
	 * @param response the response
	 * @return the response entity
	 * @throws LibraryException the library exception
	 */
	@PostMapping(value = RequestMappingConstants.ADD_USER)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResponseEntity<?> addUser(@RequestBody UserDTO userDto) throws LibraryException {
		LOGGER.info("addUser execution starts");
		ResponseDetails responseDetails = new ResponseDetails();
		try {
			UserDTO resUser = ObjectMapperUtils.map((userService.addUser(ObjectMapperUtils.map(userDto, User.class))),
					UserDTO.class);
			responseDetails.setMessageID(Long.toString(resUser.getUserId()));
			responseDetails.setMessageReason("User Added successfully");
		} catch (Exception e) {
			throw new LibraryException(AppConstants.EXCEPTION,
					"getCause: " + e.getCause() + ": getMessage Starts: " + e.getMessage());

		}
		LOGGER.info("addUser execution end");
		return new ResponseEntity<ResponseDetails>(responseDetails, HttpStatus.OK);
	}

	/**
	 * Update user details.
	 *
	 * @param userDTO the user DTO
	 * @param request the request
	 * @return the response entity
	 * @throws LibraryException the library exception
	 */
	@ResponseStatus(HttpStatus.CREATED)
	@PutMapping(value = RequestMappingConstants.UPDATE_USER)
	@ResponseBody
	public ResponseEntity<?> updateUserDetails(@RequestBody UserDTO userDTO)
			throws LibraryException {
		LOGGER.info("updateUserDetails execution starts");
		ResponseDetails responseDetails = new ResponseDetails();
		try {
			UserDTO resUser = ObjectMapperUtils
					.map((userService.updateUserDetails(ObjectMapperUtils.map(userDTO, User.class))), UserDTO.class);
			responseDetails.setMessageID(Long.toString(resUser.getUserId()));
			responseDetails.setMessageReason("User Updated successfully");
		} catch (Exception e) {
			throw new LibraryException(AppConstants.EXCEPTION,
					"getCause: " + e.getCause() + ": getMessage Starts: " + e.getMessage());
		}
		LOGGER.info("updateUserDetails execution end");
		return new ResponseEntity<ResponseDetails>(responseDetails, HttpStatus.OK);
	}

	/**
	 * Change password.
	 *
	 * @param userDTO the user DTO
	 * @param request the request
	 * @return the response entity
	 * @throws LibraryException the library exception
	 */
	@ResponseStatus(HttpStatus.CREATED)
	@PutMapping(value = RequestMappingConstants.CHANGE_PASSWORD)
	@ResponseBody
	public ResponseEntity<?> changePassword(@RequestBody UserDTO userDTO)
			throws LibraryException {
		LOGGER.info("changePassword execution starts");
		ResponseDetails responseDetails = new ResponseDetails();
		try {
			UserDTO resUser = ObjectMapperUtils
					.map((userService.updateUserDetails(ObjectMapperUtils.map(userDTO, User.class))), UserDTO.class);
			responseDetails.setMessageID(Long.toString(resUser.getUserId()));
			responseDetails.setMessageReason("Password Updated successfully");
		} catch (Exception e) {
			throw new LibraryException(AppConstants.EXCEPTION,
					"getCause: " + e.getCause() + ": getMessage Starts: " + e.getMessage());
		}
		LOGGER.info("changePassword execution end");
		return new ResponseEntity<ResponseDetails>(responseDetails, HttpStatus.OK);
	}

	/**
	 * Update role.
	 *
	 * @param userDTO the user DTO
	 * @param request the request
	 * @return the response entity
	 * @throws LibraryException the library exception
	 */
	@ResponseStatus(HttpStatus.CREATED)
	@PutMapping(value = RequestMappingConstants.UPDATE_ROLE)
	@ResponseBody
	public ResponseEntity<?> updateRole(@RequestBody UserDTO userDTO)
			throws LibraryException {
		LOGGER.info("updateRole execution starts");
		ResponseDetails responseDetails = new ResponseDetails();
		try {
			UserDTO resUser = ObjectMapperUtils
					.map((userService.updateUserDetails(ObjectMapperUtils.map(userDTO, User.class))), UserDTO.class);
			responseDetails.setMessageID(Long.toString(resUser.getUserId()));
			responseDetails.setMessageReason("Password Updated successfully");
		} catch (Exception e) {
			throw new LibraryException(AppConstants.EXCEPTION,
					"getCause: " + e.getCause() + ": getMessage Starts: " + e.getMessage());
		}
		LOGGER.info("updateRole execution end");
		return new ResponseEntity<ResponseDetails>(responseDetails, HttpStatus.OK);
	}

	/**
	 * Delete user.
	 *
	 * @param id the id
	 * @return the response entity
	 * @throws LibraryException the library exception
	 */
	@DeleteMapping(value = RequestMappingConstants.DELETE_USER)
	public ResponseEntity<?> deleteUser(@PathVariable("user_id") Long id) throws LibraryException {
		LOGGER.info("deleteUser execution start");
		ResponseDetails responseDetails = new ResponseDetails();

		try {
			if (userService.deleteUserById(id)) {
				responseDetails.setMessageReason("User Deleted Sucessfully");
			}
		} catch (Exception e) {
			throw new LibraryException(AppConstants.EXCEPTION,
					"getCause: " + e.getCause() + ": getMessage Starts: " + e.getMessage());
		}
		LOGGER.info("deleteUser execution end");
		return new ResponseEntity<ResponseDetails>(responseDetails, HttpStatus.OK);
	}

	/**
	 * List books.
	 *
	 * @return the list
	 * @throws LibraryException the library exception
	 */
	@GetMapping(value = RequestMappingConstants.LIST_USER)
	public @ResponseBody List<UserDTO> listUsers() throws LibraryException {
		LOGGER.info("listUsers execution start");
		List<UserDTO> booksList = new ArrayList<>();

		try {
			List<User> users = userService.findAll();
			for (User user : users) {
				UserDTO userdto = new UserDTO();
				userdto.setUserId(user.getUserId());
				userdto.setUserName(user.getUserName());
				userdto.setPhoneUmber(user.getPhoneNumber());
				userdto.setEmail(user.getEmail());
				booksList.add(userdto);
			}
		} catch (HibernateException e) {
			throw new LibraryException(AppConstants.DATABASE_EXCEPTION,
					"getCause: " + e.getCause() + " :  getMessage Starts:  " + e.getMessage());
		} catch (Exception e) {
			throw new LibraryException(AppConstants.EXCEPTION,
					"getCause: " + e.getCause() + ": getMessage Starts: " + e.getMessage());

		}
		LOGGER.info("listUsers execution end");
		return booksList;
	}

}
