package com.exam.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.daorep.QuizRepositoryDao;
import com.exam.model.category.Category;
import com.exam.model.category.Quiz;
import com.exam.service.QuizService;

@Service
public class QuizServiceImpl implements QuizService{

	@Autowired
	private QuizRepositoryDao quizRepositoryDao;
	@Override
	public Quiz addQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		return this.quizRepositoryDao.save(quiz);
	}

	@Override
	public Quiz update(Quiz quiz) {
		// TODO Auto-generated method stub
		return this.quizRepositoryDao.save(quiz);
	}

	@Override
	public Set<Quiz> getQuizs() {
		// TODO Auto-generated method stub
		return new HashSet<>(this.quizRepositoryDao.findAll());
	}

	@Override
	public Quiz getQuiz(int quizId) {
		// TODO Auto-generated method stub
		return this.quizRepositoryDao.findById(quizId).get();
	}

	@Override
	public void deleteQuiz(int quizId) {
		// TODO Auto-generated method stub
		
		
		this.quizRepositoryDao.deleteById(quizId);
	}

	@Override
	public List<Quiz> getQuizzesOfCategory(Category category) {
		// TODO Auto-generated method stub
		return this.quizRepositoryDao.findBycategory(category);
	}

}
