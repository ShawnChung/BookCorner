package com.shawnana.bookcorner.daoimpl.mybatis.mappers.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shawnana.bookcorner.daoimpl.mybatis.mappers.UserMapper;
import com.shawnana.bookcorner.domain.Department;
import com.shawnana.bookcorner.domain.User;
import com.shawnana.bookcorner.domain.User.Gender;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:mybatis-spring-unittest.xml")
public class UserMapperTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserMapperTest.class);
	
	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void testFindAllUsers() {
		List<User> users = userMapper.findAllUsers();
		assertNotNull(users);
		assertTrue(users.size() > 0);
	}
	
	@Test
	public void testFindUserById() {
		List<User> users = userMapper.findAllUsers();
		User expected = users.get(0);
		User user = userMapper.findUserById(expected.getId());
		assertNotNull(user);
		assertEquals(expected, user);
	}
	
	@Test
	public void testFindUserByUserno() {
		User user = userMapper.findUserByUserno("209461");
		assertNotNull(user);
	}
	
	@Test
	public void testFindUserByUsernoEmpty() {
		User user = userMapper.findUserByUserno("indws");
		assertNull(user);
	}
	
	@Test
	public void testInsertUser() {
		int userCount = userMapper.findAllUsers().size();
		User newUser = new User();
		newUser.setUserno("000001");
		newUser.setUsername("user1");
		newUser.setGender(Gender.MALE);
		Department dep1 = new Department();
		dep1.setId(1);
		newUser.setDepartment(dep1);
		newUser.setPassword("");
		assertEquals(1, userMapper.insertUser(newUser));
		assertNotNull(newUser.getId());
		assertEquals(userCount + 1, userMapper.findAllUsers().size());
	}
	
	@Test
	public void testUpdateUser() {
		List<User> users = userMapper.findAllUsers();
		User user = users.get(0);
		String newUsername = "newUsername";
		user.setUsername(newUsername);
		int updateRowCount = userMapper.updateUser(user);
		assertEquals(1, updateRowCount);
		User updatedUser = userMapper.findUserById(user.getId());
		assertEquals(newUsername, updatedUser.getUsername());	
	}
	
	@Test
	public void testUpdateUnExistUser() {
		List<User> users = userMapper.findAllUsers();
		User user = users.get(0);
		user.setId(-1);
		String newUsername = "newUsername";
		user.setUsername(newUsername);
		int updateRowCount = userMapper.updateUser(user);
		assertEquals(0, updateRowCount);
	}
	
	@Test
	public void testDeleteUserById() {
		User user = userMapper.findAllUsers().get(0);
		int deleteRowCount = userMapper.deleteUserById(user.getId());
		assertEquals(1, deleteRowCount);
		assertNull(userMapper.findUserById(user.getId()));
	}
	
	@Test
	public void testDeleteUnExistId() {
		Integer id = null;
		try {
			userMapper.deleteUserById(id);
			fail("should throw an exception.");
		} catch(NullPointerException e) {
			assertTrue(true);
		}
		
		id = -1;
		int deleteRowCount = userMapper.deleteUserById(id);
		assertEquals(0, deleteRowCount);
	}
}
