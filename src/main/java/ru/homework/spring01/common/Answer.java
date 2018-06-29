package ru.homework.spring01.common;

public class Answer {
    private String variant;
    private boolean right;

    public Answer(String variant, boolean right) {
        this.variant = variant;
        this.right = right;
    }

    public String getVariant() {
        return variant;
    }

    public boolean getRight() {
        return right;
    }
    
    public String toString() { 
    	return variant;  
     }     
}
