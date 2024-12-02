package com.exam.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.daorep.QuesationRespositoryDao;
import com.exam.model.category.Quesations;
import com.exam.model.category.Quiz;
import com.exam.service.QueastionService;


@Service
public class QuesationServiceImpl  implements QueastionService{

	@Autowired
	private QuesationRespositoryDao quesationRespositoryDao;

	@Override
	public Quesations addQuesation(Quesations quesations) {
		// TODO Auto-generated method stub
		return this.quesationRespositoryDao.save(quesations);
	}

	@Override
	public Quesations updateQuesation(Quesations quesations) {
		// TODO Auto-generated method stub
		return this.quesationRespositoryDao.save(quesations);
	}

	@Override
	public Set<Quesations> getQuesationses() {
		// TODO Auto-generated method stub
		return new HashSet<>(this.quesationRespositoryDao.findAll());
	}

	@Override
	public Quesations getQuesations(int qusationId) {
		// TODO Auto-generated method stub
		return this.quesationRespositoryDao.findById(qusationId).get();
	}

	@Override
	public Set<Quesations> getQuesationsOfQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		
		return this.quesationRespositoryDao.findByQuiz(quiz);
	}

	@Override
	public void deletedQuestion(int quesId) {
		Quesations quesations = new Quesations();
		quesations.setQusId(quesId);
		this.quesationRespositoryDao.delete(quesations);
		
	}
	
}
