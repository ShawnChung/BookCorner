package com.shawnana.bookcorner.service;

import com.shawnana.bookcorner.domain.User;
import com.shawnana.bookcorner.infra.exception.UserAleadyExistException;

public interface UserService {
	/**
	 * 用户注册。注册成功返回用户domain，失败则返回null
	 * @param user 新注册的用户domain对象
	 * @return 注册完成的用户domain对象
	 * @throws UserAleadyExistException 
	 */
	User userRegister(User user) throws UserAleadyExistException;
}
