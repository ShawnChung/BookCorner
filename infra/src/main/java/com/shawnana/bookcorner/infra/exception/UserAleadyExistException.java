package com.shawnana.bookcorner.infra.exception;

public class UserAleadyExistException extends Exception {
	public UserAleadyExistException(String userNo) {
		super(new StringBuilder("User ").append(userNo)
				.append(" Aleady exists.").toString());
	}
}
