package ru.homework.spring01.common;

import java.util.ArrayList;

public class TestUnit {
	
    private String question;
    private ArrayList<Answer> answerList;

    public String getQuestion() {
        return question;
    }    
    
    public void setQuestion(String question) {
        this.question = question;
    }    
    
    public ArrayList<Answer> getAnswerList() {
        return answerList;
    }	
    
    public void setAnswerList(ArrayList<Answer> AnswerList) {
        this.answerList = AnswerList;
    }     
       
}
