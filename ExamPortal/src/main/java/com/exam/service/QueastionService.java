package com.exam.service;

import java.util.Set;

import com.exam.model.category.Quesations;
import com.exam.model.category.Quiz;

public interface QueastionService {

	public Quesations addQuesation(Quesations quesations);
	
	public Quesations updateQuesation(Quesations quesations);
	
	public Set<Quesations> getQuesationses();
	
	public Quesations getQuesations(int qusationId);
	
	public Set<Quesations> getQuesationsOfQuiz(Quiz quiz);
	
	public void deletedQuestion(int quesId);
}
