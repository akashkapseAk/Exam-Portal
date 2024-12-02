package com.exam.model.category;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Quiz {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int qid;
	private String title;
	
	private String description;
	
	private String MaxMarks;
	private String numberOfQuesations;
	
	private boolean active=false;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Category category;
	
	

	public Set<Quesations> getQuesation() {
		return quesation;
	}

	public void setQuesation(Set<Quesations> quesation) {
		this.quesation = quesation;
	}

	@OneToMany(mappedBy = "quiz",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Quesations> quesation=new HashSet<>();
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Quiz() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMaxMarks() {
		return MaxMarks;
	}

	public void setMaxMarks(String maxMarks) {
		MaxMarks = maxMarks;
	}

	public String getNumberOfQuesations() {
		return numberOfQuesations;
	}

	public void setNumberOfQuesations(String numberOfQuesations) {
		this.numberOfQuesations = numberOfQuesations;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	
}
