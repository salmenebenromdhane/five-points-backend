package com.ensat.services;

import java.text.ParseException;

import com.ensat.entities.Subject;
import com.ensat.entities.User;

public interface IUserService {

	public User register(User u);
	public User login(String login,String pwd);
	public String voter(int idSubject,String vote) throws ParseException;
}
