package com.shawnana.bookcorner.serviceimpl.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

import com.shawnana.bookcorner.dao.UserDao;
import com.shawnana.bookcorner.domain.User;
import com.shawnana.bookcorner.infra.exception.UserAleadyExistException;
import com.shawnana.bookcorner.serviceimpl.UserServiceImpl;

public class UserServiceImplTest {
	private UserServiceImpl userService;
	
	private UserDao userDao;
	
	private User dummyUser;
	private User returnUser;
	
	@Before
	public void setUp() {
		userService = new UserServiceImpl();
		userDao = mock(UserDao.class);
		userService.setUserDao(userDao);
		
		String userName = "Shawn";
		String userNo = "203991";
		String pwd = "iensoksdfon";
		dummyUser = new User();
		dummyUser.setUsername(userName);
		dummyUser.setUserno(userNo);
		dummyUser.setPassword(pwd);
		returnUser = new User();
		returnUser.setUsername(userName);
		returnUser.setUserno(userNo);
		returnUser.setPassword(pwd);
		returnUser.setId(2);
	}
	
	@Test
	public void testUserRegistSeccess() throws UserAleadyExistException {
		when(userDao.findUserByUserno(dummyUser.getUserno())).thenReturn(null);
		when(userDao.insertUser(dummyUser)).thenReturn(1);
		assertEquals(returnUser, userService.userRegister(dummyUser));
	}
	
	@Test(expected = UserAleadyExistException.class)
	public void testUserRegistFailBecauseUserExist() throws UserAleadyExistException {
		when(userDao.findUserByUserno(dummyUser.getUserno())).thenReturn(returnUser);
		assertEquals(null, userService.userRegister(dummyUser));
		verify(userDao, times(0)).insertUser(any(User.class));
	}
}
