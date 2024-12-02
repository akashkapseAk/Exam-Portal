package com.exam.controller;


import java.util.ArrayList;


import java.util.Collections;
import java.util.List;
import java.util.Set;

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

import com.exam.model.category.Quesations;
import com.exam.model.category.Quiz;
import com.exam.service.QueastionService;
import com.exam.service.QuizService;




@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuesationController {

	@Autowired
	private QueastionService queastionService;
	
	@Autowired
	private QuizService quizService;
	
	//add question
	
	@PostMapping("/")
	public ResponseEntity<Quesations> addQus(@RequestBody Quesations quesations)
	{
		return ResponseEntity.ok(this.queastionService.addQuesation(quesations));
		
	}
	
	//update question
	
	@PutMapping("/")
	public ResponseEntity<Quesations> updateQus(@RequestBody Quesations quesations)
	{
		return ResponseEntity.ok(this.queastionService.updateQuesation(quesations));
	}
	
	//getall question of any quiz
	
	@GetMapping("/quiz/{qid}")
	public ResponseEntity<?> getQustionOfQuiz(@PathVariable("qid") Integer qid)
	{
//		Quiz quiz = new Quiz();
//		quiz.setQid(qid);
		
		Quiz quiz = this.quizService.getQuiz(qid);
		Set<Quesations> quesations=quiz.getQuesation();
		
	     List list=new ArrayList(quesations);
	     
	     if(list.size()>Integer.parseInt(quiz.getNumberOfQuesations()))
	     {
	    	list= list.subList(0, Integer.parseInt(quiz.getNumberOfQuesations()+1));
	     }
	     
	     Collections.shuffle(list);
	     
	    return ResponseEntity.ok(list);
	}
	
	//getsingle question
	
	@GetMapping("/{qusid}")
	public Quesations get(@PathVariable("qusid") Integer qusid)
	{
		return this.queastionService.getQuesations(qusid);
		
	}
	
	//delete Qustion
	@DeleteMapping("/{qusid}")
	public void deleteQus(@PathVariable("qusid") Integer qusid)
	
	{
		this.queastionService.deletedQuestion(qusid);
	}
}
