package com.library.service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.library.dao.repositories.UserRepository;
import com.library.entity.User;
import com.library.service.impl.UserServiceImpl;

public class UserServiceTest {

	public static final String USER_NAME = "ABC User";
	public static final long USER_ID = 1;
	public static final String USER_ROLE = "1";
	public static final String USER_EMAIL = "abc@abc.com";
	public static final String ADDRESS = "Noida";
	public static final String PHONE_NUMBER = "9811111";

	@InjectMocks
	private UserServiceImpl userService;

	@Mock
	private UserRepository userRepository;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		List<User> users = new ArrayList<>();
		users.add(getUserEntity());
		when(userRepository.getOne(USER_ID)).thenReturn(getUserEntity());
		when(userService.addUser(getUserEntity())).thenReturn(getUserEntity());
		when(userService.updateUserDetails(getUserEntity())).thenReturn(getUserEntity());
		when(userService.listUsers()).thenReturn(users);
	}

	@Test
	public void addUserTest() {
		User UserResult = userService.addUser(getUserEntity());
		Assert.assertEquals(USER_ID, UserResult.getUserId());
		Assert.assertEquals(USER_NAME, UserResult.getUserName());
		Assert.assertEquals(ADDRESS, UserResult.getAddress());
		Assert.assertEquals(PHONE_NUMBER, UserResult.getPhoneNumber());
		Assert.assertEquals(USER_ROLE, UserResult.getRoleId());
		Assert.assertEquals(USER_EMAIL, UserResult.getEmail());
	}

	@Test
	public void updateUserTest() {

		User UserResult = userService.updateUserDetails(getUserEntity());
		Assert.assertEquals(USER_ID, UserResult.getUserId());
		Assert.assertEquals(USER_NAME, UserResult.getUserName());
		Assert.assertEquals(ADDRESS, UserResult.getAddress());
		Assert.assertEquals(PHONE_NUMBER, UserResult.getPhoneNumber());
		Assert.assertEquals(USER_ROLE, UserResult.getRoleId());
		Assert.assertEquals(USER_EMAIL, UserResult.getEmail());
	}

	@Test
	public void listUsersTest() {
		List<User> UsersActual = userService.listUsers();
		Assert.assertEquals(1, UsersActual.size());
		Assert.assertEquals(USER_ID, UsersActual.get(0).getUserId());
		Assert.assertEquals(USER_NAME, UsersActual.get(0).getUserName());
		Assert.assertEquals(ADDRESS, UsersActual.get(0).getAddress());
		Assert.assertEquals(PHONE_NUMBER, UsersActual.get(0).getPhoneNumber());
		Assert.assertEquals(USER_ROLE, UsersActual.get(0).getRoleId());
		Assert.assertEquals(USER_EMAIL, UsersActual.get(0).getEmail());
	}

	@Test
	public void deleteUserTest() {
		boolean deleteResult = userService.deleteUserById(USER_ID);
		Assert.assertTrue(deleteResult);
	}

	public User getUserEntity() {
		User user = new User();
		user.setUserId(USER_ID);
		user.setAddress(ADDRESS);
		user.setUserName(USER_NAME);
		user.setPhoneNumber(PHONE_NUMBER);
		user.setRoleId(USER_ROLE);
		user.setEmail(USER_EMAIL);
		return user;
	}
}
