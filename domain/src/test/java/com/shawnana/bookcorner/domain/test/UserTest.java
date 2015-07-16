package com.shawnana.bookcorner.domain.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.shawnana.bookcorner.domain.Department;
import com.shawnana.bookcorner.domain.User;
import com.shawnana.bookcorner.domain.User.Gender;

public class UserTest {
	@Test
	public void testNew() {
		User user = new User();
		Integer id = 1;
		user.setId(id);
		assertEquals(id, user.getId());
		String userno = "209461";
		user.setUserno(userno);
		assertEquals(userno, user.getUserno());
		Gender gender = User.Gender.MALE;
		user.setGender(gender);
		assertEquals(gender, user.getGender());
		Department department = new Department();
		user.setDepartment(department);
		assertEquals(department, user.getDepartment());
	}
	
	@Test
	public void testEquals() {
		
	}
}
