package com.shawnana.bookcorner.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.shawnana.bookcorner.dao.UserDao;
import com.shawnana.bookcorner.domain.User;
import com.shawnana.bookcorner.infra.exception.UserAleadyExistException;
import com.shawnana.bookcorner.service.UserService;

public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	@Override
	public User userRegister(User user) throws UserAleadyExistException {
		if (userDao.findUserByUserno(user.getUserno()) != null)
			throw new UserAleadyExistException(user.getUserno());
		if (userDao.insertUser(user) != 1)
			return null;
		return user;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
