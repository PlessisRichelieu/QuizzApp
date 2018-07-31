package com.example.niki.quizzapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MediumMode extends AppCompatActivity {

    Questions [] questionBank = { new Questions(R.string.mQuestion1, R.string.mAnswer1_1, R.string.mAnswer1_2, R.string.mAnswer1_3, R.string.mAnswer1_4,3),
                                  new Questions (R.string.mQuestion2, R.string.mAnswer2_1, R.string.mAnswer2_2, R.string.mAnswer2_3, R.string.mAnswer2_4,1 ),
                                  new Questions (R.string.mQuestion3, R.string.mAnswer3_1, R.string.mAnswer3_2, R.string.mAnswer3_3, R.string.mAnswer3_4, 4),
                                  new Questions (R.string.mQuestion4, R.string.mAnswer4_1, R.string.mAnswer4_2, R.string.hAnswer4_3, R.string.mAnswer4_4, 2),
                                  new Questions (R.string.mQuestion5, R.string.mAnswer5_1, R.string.mAnswer5_2, R.string.mAnswer5_3, R.string.hAnswer5_4, 2)

    };

    TextView Question;

    TextView Answer1;

    TextView Answer2;

    TextView Answer3;

    TextView Answer4;


    int userChoice;

    int questIndex;

    int Score;

    int nxtQuestion;

    int nxtAnswer1;

    int nxtAnswer2;

    int nxtAnswer3;

    int nxtAnswer4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medium_mode);

        Question = findViewById(R.id.Question);

        Answer1 = findViewById(R.id.Answer1);

        Answer2 = findViewById(R.id.Answer2);

        Answer3 = findViewById(R.id.Answer3);

        Answer4 = findViewById(R.id.Answer4);

        Answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userChoice =1;
                checkAnswer(questionBank[questIndex]);
                winCondition();


            }
        });

        Answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userChoice = 2;
                checkAnswer(questionBank[questIndex]);
                winCondition();
            }
        });

        Answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userChoice=3;
                checkAnswer(questionBank[questIndex]);
                winCondition();
            }
        });

        Answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userChoice = 4;
                checkAnswer(questionBank[questIndex]);
                winCondition();
            }
        });


    }

    public void checkAnswer (Questions question){

        if (userChoice==question.getCorrectAnswer())
        {
            Toast.makeText(getApplicationContext(), R.string.correctMsg, Toast.LENGTH_SHORT).show();
            Score+=1;
            updateQuestion();
        }
        else
        {
            Toast.makeText(getApplicationContext(),R.string.incorrectMsg, Toast.LENGTH_SHORT).show();

        }
    }
    public void updateQuestion (){
        questIndex = (questIndex + 1)%questionBank.length;

        nxtQuestion = questionBank [questIndex].getQuestion();
        Question.setText(nxtQuestion);

        nxtAnswer1 = questionBank [questIndex].getAnswer1();
        Answer1.setText(nxtAnswer1);

        nxtAnswer2 = questionBank [questIndex].getAnswer2();
        Answer2.setText(nxtAnswer2);

        nxtAnswer3 = questionBank [questIndex].getAnswer3();
        Answer3.setText(nxtAnswer3);

        nxtAnswer4 = questionBank [questIndex].getAnswer4();
        Answer4.setText(nxtAnswer4);

    }

    public void winCondition (){

        if (Score == 5){

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage(R.string.alertDialogTitle);
            alertDialogBuilder.setPositiveButton(R.string.alertDialogStop, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent i = new Intent (MediumMode.this, MainActivity.class);
                    startActivity(i);

                }
            });

            alertDialogBuilder.setNegativeButton(R.string.alertDialogContinue, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Score=0;
                }
            });

            AlertDialog alertMsg = alertDialogBuilder.create();
            alertMsg.show();

        }
    }

}
