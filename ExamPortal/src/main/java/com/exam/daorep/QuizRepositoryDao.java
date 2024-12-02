package com.exam.daorep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.model.category.Category;
import com.exam.model.category.Quiz;

public interface QuizRepositoryDao extends JpaRepository<Quiz, Integer>{
	
	public List<Quiz> findBycategory(Category category);

}
