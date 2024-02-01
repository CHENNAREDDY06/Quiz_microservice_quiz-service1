package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("quiz")
public class QuizController {
	  
	@Autowired
	QuizService quizService;
	
	@PostMapping("create")
	public ResponseEntity<String> createQuiz(@RequestBody QuizDto dto){
		return  quizService.createQuiz(dto.getCategoryName(), dto.getNumQuestions(),dto.getTitle());
	}
	
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable int id){
    	return quizService.getQuizQuestions(id);
    }
	
    @PostMapping("submit")
    public ResponseEntity<Integer> submitQuiz( @RequestBody List<Response> responses){
    	return quizService.calculateResult( responses);
    }
	
	
}
