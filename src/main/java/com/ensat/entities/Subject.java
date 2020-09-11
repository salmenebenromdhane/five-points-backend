package com.ensat.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Subject {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
private String titre;
private String description;
private int totalVote;
private int nbVoteOui;
@ManyToOne
private User user;

public Subject(){}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getTitre() {
	return titre;
}
public void setTitre(String titre) {
	this.titre = titre;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}

public int getTotalVote() {
	return totalVote;
}
public void setTotalVote(int totalVote) {
	this.totalVote = totalVote;
}
public int getNbVoteOui() {
	return nbVoteOui;
}
public void setNbVoteOui(int nbVoteOui) {
	this.nbVoteOui = nbVoteOui;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public Subject(String titre, String description,User user) {
	super();
	this.titre = titre;
	this.description = description;
	this.user=user;
}

}
