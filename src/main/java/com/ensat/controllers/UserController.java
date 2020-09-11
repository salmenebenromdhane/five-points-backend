package com.ensat.controllers;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ensat.entities.Subject;
import com.ensat.entities.User;
import com.ensat.services.IUserService;


@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private IUserService userService;
	

	@PostMapping("register")
	public ResponseEntity<User> register(@RequestBody User u){
		User user=null;
		user=userService.register(u);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@GetMapping("login")
	public ResponseEntity<User> login(@RequestParam String login,@RequestParam String pwd){
		User user=null;
		user=userService.login(login, pwd);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@GetMapping("vote")
	public ResponseEntity<String> vote(@RequestParam int idSubject,@RequestParam String vote) throws ParseException{
		String v="";
		v=userService.voter(idSubject, vote);
		return new ResponseEntity<String>(v, HttpStatus.OK);
	}
	
	
	
}
