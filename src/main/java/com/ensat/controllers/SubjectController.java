package com.ensat.controllers;

import java.util.ArrayList;
import java.util.List;

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
import com.ensat.services.ISubjectService;
import com.ensat.services.IUserService;

@Controller
@RequestMapping("subject")
public class SubjectController {

	@Autowired
	private ISubjectService subjectService;
	
	@GetMapping("addSubject")
	public ResponseEntity<Subject> addSubject(@RequestParam int u,@RequestParam String titre,@RequestParam String description){
		Subject Subject=null;
		Subject=subjectService.addSubject(titre,description ,u);
		return new ResponseEntity<Subject>(Subject, HttpStatus.OK);
	}
	
	@GetMapping("allSubjects")
	public ResponseEntity <List<Subject>> allSubjects(){
		List<Subject> list = new ArrayList<>();
        list=subjectService.allSubjects();
		return new ResponseEntity<List<Subject>>  (list, HttpStatus.OK);
	}
}
