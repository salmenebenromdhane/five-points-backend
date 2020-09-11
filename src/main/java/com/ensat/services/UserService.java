package com.ensat.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensat.entities.Subject;
import com.ensat.entities.User;
import com.ensat.repositories.SubjectRepository;
import com.ensat.repositories.UserRepository;

@Service
public class UserService implements IUserService{

	@PersistenceContext
    private EntityManager em;
	@Autowired
	private UserRepository repo;
	@Autowired
	private SubjectRepository repoSubject;
	@Override
	public User register(User u) {
		return repo.save(u);
		
	}

	@Override
	public User login(String login, String pwd) {
		User user=null;
		try{user = em.createQuery("select u from User u where u.login='" + login+"' and u.pwd='"+pwd+"'", User.class)
				.getSingleResult();

	} catch (javax.persistence.PersistenceException k) {
		return null;
	}
		return user;
	}

	@Override
	public String voter(int idSubject, String vote) throws ParseException {
		Subject s=null;
		try{
			s = em.createQuery("select u from Subject u where u.id="+idSubject, Subject.class)
				.getSingleResult();

		} catch (javax.persistence.PersistenceException k) {
		return null;
		}
		
		
		
		 if(s.getUser().getLastVote()!=null) {
			 System.out.println("zzzzzzzzzzzzz");
			 Date lastDate=new SimpleDateFormat("dd/MM/yyyy").parse(s.getUser().getLastVote());
			
			 System.out.println("qqqqqqqqqqqqq"+lastDate);
			 Date date = new Date(); 
			 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
			    String strDate= formatter.format(date); 
			    Date dateToday=new SimpleDateFormat("dd/MM/yyyy").parse(strDate);
			 System.out.println("qqqqqqqqqqqqq"+dateToday);  
			 if((lastDate.equals(dateToday)&&s.getUser().getNbVoteJour()<=5)) {
				 
				 System.out.println("sssssssssssssssss");
				 s.getUser().setLastVote(strDate);
				 s.getUser().setNbVoteJour(s.getUser().getNbVoteJour()+1);
				 repo.save(s.getUser());
				 if(vote.equals("oui")) s.setNbVoteOui(s.getNbVoteOui()+1);
				 s.setTotalVote(s.getTotalVote()+1);
				 repoSubject.save(s);
				 return vote;
			 }
			 else if((lastDate.before(dateToday))) {
				 
				 s.getUser().setLastVote(strDate);
				 s.getUser().setNbVoteJour(1);
				 repo.save(s.getUser());
				 if(vote.equals("oui")) s.setNbVoteOui(s.getNbVoteOui()+1);
				 s.setTotalVote(s.getTotalVote()+1);
				 repoSubject.save(s);
				 return vote;
			 }
			 else {
				 return "demain";
			 }
		 }
		return null;
		
		
	}

}
