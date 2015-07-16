package com.shawnana.bookcorner.dao;

import java.util.List;

import com.shawnana.bookcorner.domain.User;

public interface UserDao {
	public List<User> findAllUsers();
	
	public User findUserById(int id);
	
	public User findUserByUserno(String userno);

	public int insertUser(User user);

	public int updateUser(User user);

	public int deleteUserById(int id);
}
