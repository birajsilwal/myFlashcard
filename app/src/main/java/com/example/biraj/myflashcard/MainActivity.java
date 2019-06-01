package com.example.biraj.myflashcard;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.flashcard_question).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.flashcard_answer).setVisibility(View.VISIBLE);
                findViewById(R.id.flashcard_question).setVisibility(View.INVISIBLE);
            }
        });

        findViewById(R.id.flashcard_answer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.flashcard_answer).setVisibility(View.INVISIBLE);
                findViewById(R.id.flashcard_question).setVisibility(View.VISIBLE);
            }
        });

//for options (correct and incorrect)

        findViewById(R.id.incorrect_answer1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackground(getResources().getDrawable(R.drawable.incorrect_option_background));
                findViewById(R.id.correct_answer).setBackground(getResources().getDrawable(R.drawable.correct_option_background));
            }
        });

        findViewById(R.id.incorrect_answer2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackground(getResources().getDrawable(R.drawable.incorrect_option_background));
                findViewById(R.id.correct_answer).setBackground(getResources().getDrawable(R.drawable.correct_option_background));
            }
        });

        findViewById(R.id.correct_answer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.correct_answer).setBackground(getResources().getDrawable(R.drawable.correct_option_background));
            }
        });

        findViewById(R.id.main_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.incorrect_answer1).setBackground(getResources().getDrawable(R.drawable.option_background));
                findViewById(R.id.incorrect_answer2).setBackground(getResources().getDrawable(R.drawable.option_background));
                findViewById(R.id.correct_answer).setBackground(getResources().getDrawable(R.drawable.option_background));
            }
        });


        findViewById(R.id.add_card).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddCardActivity.class);
                MainActivity.this.startActivityForResult(intent, 100);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 100) {
            String question = data.getExtras().getString("question");
            String correct_answer = data.getExtras().getString("correct_answer");
            String wrong_answer1 = data.getExtras().getString("wrong_answer1");
            String wrong_answer2 = data.getExtras().getString("wrong_answer2");
        }
    }


}
