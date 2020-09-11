package com.ensat.services;

import java.util.List;

import com.ensat.entities.Subject;
import com.ensat.entities.User;

public interface ISubjectService {

	public Subject addSubject(String titre,String description ,int user);
	public List<Subject> allSubjects();
}
