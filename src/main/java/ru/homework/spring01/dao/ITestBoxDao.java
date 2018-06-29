package ru.homework.spring01.dao;

import java.util.ArrayList;

import ru.homework.spring01.common.Answer;
import ru.homework.spring01.common.TestUnit;

public interface ITestBoxDao {
	
	boolean EOF(); 
	int Count();  
	TestUnit Next();
	
	String GetQuestion();  
	ArrayList<Answer> GetAnswers(); 	

}
