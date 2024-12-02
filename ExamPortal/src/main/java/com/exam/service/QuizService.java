package com.exam.service;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;

import com.exam.model.category.Category;
import com.exam.model.category.Quiz;


 
public interface QuizService {

	public Quiz addQuiz(Quiz quiz);
	
	public Quiz update(Quiz quiz);
	
	public Set<Quiz> getQuizs();
	
	public Quiz getQuiz(int quizId);
	
	public void deleteQuiz(int quizId);

	public List<Quiz> getQuizzesOfCategory(Category category);

	
}
