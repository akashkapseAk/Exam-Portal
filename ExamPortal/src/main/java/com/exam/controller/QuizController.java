package com.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.category.Category;
import com.exam.model.category.Quesations;
import com.exam.model.category.Quiz;
import com.exam.service.QueastionService;
import com.exam.service.QuizService;

@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizController {

	@Autowired
	private QuizService quizService;
	
	//adding quizz
	
	@PostMapping("/")
	public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz)
	{
		return ResponseEntity.ok(this.quizService.addQuiz(quiz));
	}
	
	//update quiz
	@PutMapping("/")
	public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz)
	{
		return ResponseEntity.ok(this.quizService.update(quiz));
		
	}
	//get quiz
	@GetMapping("/")
	public ResponseEntity<?> quizes()
	{
		return ResponseEntity.ok(this.quizService.getQuizs());
	}
	
	//get Single quiz
	
	@GetMapping("/{qid}")
	public Quiz quiz(@PathVariable("qid") Integer qid)
	{
		return this.quizService.getQuiz(qid);
		
	}
	//deleted quiz
	@DeleteMapping("/{qid}")
	public void delete(@PathVariable("qid") Integer qid)
	{
		this.quizService.deleteQuiz(qid);
	}
	//speifice quizz
	
	@GetMapping("/category/{cid}")
  public List<Quiz> getQuizzesOfCategory(@PathVariable("cid") Integer cid)
  {
		Category category = new Category();
		category.setCid(cid);
	return this.quizService.getQuizzesOfCategory(category);
		
  }
}
