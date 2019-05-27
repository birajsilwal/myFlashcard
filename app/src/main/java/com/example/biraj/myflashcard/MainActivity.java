package com.example.biraj.myflashcard;

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


//        findViewById(R.id.incorrect_answer1).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                v.setBackground(getResources().getDrawable(R.drawable.choice_background_incorrect));
//                findViewById(R.id.correct_answer).setBackground(getResources().getDrawable(R.drawable.choice_background_correct));
//                stopTimer();
//            }
//        });



        findViewById(R.id.incorrect_answer2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.incorrect_answer2).setBackgroundColor(getResources().getColor(R.color.my_red_color, null));
                findViewById(R.id.correct_answer).setBackgroundColor(getResources().getColor(R.color.my_green_color, null));
            }
        });

        findViewById(R.id.correct_answer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.correct_answer).setBackgroundColor(getResources().getColor(R.color.my_green_color, null));
            }
        });

/*        findViewById(R.id.incorrect_answer1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.incorrect_answer1).setBackgroundColor(getResources().getColor(R.color.my_red_color, null));
                findViewById(R.id.correct_answer).setBackgroundColor(getResources().getColor(R.color.my_green_color, null));
            }
        });*/

    }
}
