package com.ensat.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    private String login;
    private String pwd;
    private String lastVote;
    private int nbVoteJour;
public int getNbVoteJour() {
		return nbVoteJour;
	}
	public void setNbVoteJour(int nbVoteJour) {
		this.nbVoteJour = nbVoteJour;
	}
public String getLastVote() {
		return lastVote;
	}
	public void setLastVote(String lastVote) {
		this.lastVote = lastVote;
	}
public User() {}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
	public User(String login, String pwd) {
		this.login = login;
		this.pwd = pwd;
	}
    
    
}
