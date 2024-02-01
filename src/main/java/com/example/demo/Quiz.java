package com.example.demo;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Quiz {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String title;
	@ElementCollection
	private List<Integer> questionids;
	public Quiz(Integer id, String title, List<Integer> questions) {
		super();
		this.id = id;
		this.title = title;
		this.questionids = questions;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Integer> getQuestionids() {
		return questionids;
	}
	public void setQuestionids(List<Integer> questions) {
		this.questionids = questions;
	}
	
	public Quiz() {
		
	}
		@Override
	public String toString() {
		return "Quiz [id=" + id + ", title=" + title + ", questions=" + questionids + "]";
	}

		

}
