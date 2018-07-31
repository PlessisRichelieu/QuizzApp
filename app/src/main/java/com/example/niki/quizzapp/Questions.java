package com.example.niki.quizzapp;

public class Questions {

    private int Question;
    private int Answer1;
    private int Answer2;
    private int Answer3;
    private int Answer4;

    private int correctAnswer;


    public Questions (int Question, int Answer1, int Answer2, int Answer3, int Answer4, int correctAnswer){

        this.Question = Question;
        this.Answer1 = Answer1;
        this.Answer2 = Answer2;
        this.Answer3 = Answer3;
        this.Answer4 = Answer4;
        this.correctAnswer = correctAnswer;
    }

    public int getQuestion() {
        return Question;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public int getAnswer1() {
        return Answer1;
    }

    public int getAnswer2() {
        return Answer2;
    }

    public int getAnswer3() {
        return Answer3;
    }

    public int getAnswer4() {
        return Answer4;
    }
}
