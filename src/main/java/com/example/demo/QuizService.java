package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class QuizService {
	
	@Autowired
	QuizDao quizDao;

	
	@Autowired
	QuizInterface quizInterface;
	

	public ResponseEntity<String> createQuiz(String cat, int nQ, String title) {
		List<Integer> questions=quizInterface.getQuestionsForQuiz(cat,nQ).getBody();
		Quiz quiz=new Quiz();
		quiz.setQuestionids(questions);
		quiz.setTitle(title);
		quizDao.save(quiz);
		 return new ResponseEntity<>("Sucess", HttpStatus.CREATED);
		
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id) {
		  
		     Optional<Quiz> quiz=quizDao.findById(id);
		     List<Integer> questionIds=quiz.get().getQuestionids();
		   ResponseEntity<List<QuestionWrapper>> questionsForUsers=quizInterface.getQuestionsFromId(questionIds);
		return questionsForUsers;
	}
	

	public ResponseEntity<Integer> calculateResult( List<Response> responses) {
		// TODO Auto-generated method stub
		
		ResponseEntity<Integer> score=quizInterface.getScore(responses);
	       
		return score;
	}
		
}

	
	
	
