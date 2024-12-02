package com.exam.model.category;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Quesations {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int qusId;
	@Column(length = 4000)
	private String Content;
	private String image;
	
	private String opt1;
	private String opt2;
	private String opt3;
	private String opt4;
	
	private String answer;
	
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	private  Quiz quiz;



	public Quesations() {
		super();
		// TODO Auto-generated constructor stub
	}



	



	public int getQusId() {
		return qusId;
	}







	public void setQusId(int qusId) {
		this.qusId = qusId;
	}







	public String getContent() {
		return Content;
	}



	public void setContent(String content) {
		Content = content;
	}



	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}



	public String getOpt1() {
		return opt1;
	}



	public void setOpt1(String opt1) {
		this.opt1 = opt1;
	}



	public String getOpt2() {
		return opt2;
	}



	public void setOpt2(String opt2) {
		this.opt2 = opt2;
	}



	public String getOpt3() {
		return opt3;
	}



	public void setOpt3(String opt3) {
		this.opt3 = opt3;
	}



	public String getOpt4() {
		return opt4;
	}



	public void setOpt4(String opt4) {
		this.opt4 = opt4;
	}



	public String getAnswer() {
		return answer;
	}



	public void setAnswer(String answer) {
		this.answer = answer;
	}



	public Quiz getQuiz() {
		return quiz;
	}



	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}
	
	
}
