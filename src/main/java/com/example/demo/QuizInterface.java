package com.example.demo;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {
	@PostMapping("question/create/{cat}/{nQ}")
	public ResponseEntity<List<Integer>> getQuestionsForQuiz(@PathVariable String cat, @PathVariable int nQ);
	
	@PostMapping("question/getQuestions")
	public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds );
		
	 @PostMapping("question/getScore")
	 public ResponseEntity<Integer> getScore(@RequestBody  List<Response> response);
		


    
    
}
