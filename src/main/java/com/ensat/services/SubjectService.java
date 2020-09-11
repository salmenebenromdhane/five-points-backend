package com.ensat.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ensat.entities.Subject;
import com.ensat.entities.User;
import com.ensat.repositories.SubjectRepository;
import com.ensat.repositories.UserRepository;

@Service
public class SubjectService implements ISubjectService {

	@PersistenceContext
    private EntityManager em;
	@Autowired
	private SubjectRepository repo;
	@Override
	public Subject addSubject(String titre,String description ,int user) {
		User u=null;
		u =   em.createQuery("select u from User u where u.id="+user, User.class).getSingleResult();
		Subject s=new Subject();
		s.setUser(u);
		s.setTitre(titre);
		s.setDescription(description);
		return repo.save(s);
	}
	@Override
	public List<Subject> allSubjects() {
		List<Subject> list=new ArrayList<>();
		try{list = em.createQuery("select u from Subject u", Subject.class).getResultList();
	} catch (javax.persistence.PersistenceException k) {
		return list;
	}
				return list;
	}
	
}
