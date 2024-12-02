package com.exam.daorep;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.model.category.Quesations;
import com.exam.model.category.Quiz;

public interface QuesationRespositoryDao extends JpaRepository<Quesations, Integer>{

	Set<Quesations>  findByQuiz(Quiz quiz);
}
