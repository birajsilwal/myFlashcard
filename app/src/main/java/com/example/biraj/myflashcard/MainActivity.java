package com.example.biraj.myflashcard;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView flashcard_question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flashcard_question = (TextView) findViewById(R.id.flashcard_question);
        flashcard_question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.flashcard_answer).setVisibility(View.VISIBLE);
                findViewById(R.id.flashcard_question).setVisibility(View.INVISIBLE);
            }
        });


    }};

