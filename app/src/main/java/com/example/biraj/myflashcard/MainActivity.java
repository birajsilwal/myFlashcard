package com.example.biraj.myflashcard;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static int ADD_CARD_REQUEST_CODE = 0;
    static int EDIT_CARD_REQUEST_CODE = 1;

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
                MainActivity.this.startActivityForResult(intent, ADD_CARD_REQUEST_CODE);
            }
        });

        findViewById(R.id.edit_card).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent(MainActivity.this, AddCardActivity.class);
//                data.putExtra("question", "flashcard_question");
                data.putExtra("question", ((TextView) findViewById(R.id.flashcard_question)).getText().toString());
                data.putExtra("correct_answer", ((TextView) findViewById(R.id.flashcard_answer)).getText().toString());
                data.putExtra("correct_answer", ((TextView) findViewById(R.id.correct_answer)).getText().toString());
                data.putExtra("incorrect_answer1", ((TextView) findViewById(R.id.incorrect_answer1)).getText().toString());
                data.putExtra("incorrect_answer2", ((TextView) findViewById(R.id.incorrect_answer2)).getText().toString());
                MainActivity.this.startActivityForResult(data, EDIT_CARD_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       if(resultCode == RESULT_OK){
        if (requestCode == ADD_CARD_REQUEST_CODE) {
            String question = data.getExtras().getString("question");
            String correct_answer = data.getExtras().getString("correct_answer");
            String wrong_answer1 = data.getExtras().getString("wrong_answer1");
            String wrong_answer2 = data.getExtras().getString("wrong_answer2");

            ((TextView) findViewById(R.id.flashcard_question)).setText(question);
            ((TextView) findViewById(R.id.flashcard_answer)).setText(correct_answer);
            ((TextView) findViewById(R.id.correct_answer)).setText(correct_answer);
            ((TextView) findViewById(R.id.incorrect_answer1)).setText(wrong_answer1);
            ((TextView) findViewById(R.id.incorrect_answer2)).setText(wrong_answer2);
            Snackbar.make(findViewById(R.id.main_view),"Card successfully created",Snackbar.LENGTH_SHORT).show();
        }
           if (requestCode == EDIT_CARD_REQUEST_CODE) {
               String question = data.getExtras().getString("question");
               String correct_answer = data.getExtras().getString("correct_answer");
               String wrong_answer1 = data.getExtras().getString("wrong_answer1");
               String wrong_answer2 = data.getExtras().getString("wrong_answer2");

               ((TextView) findViewById(R.id.flashcard_question)).setText(question);
               ((TextView) findViewById(R.id.flashcard_answer)).setText(correct_answer);
               ((TextView) findViewById(R.id.correct_answer)).setText(correct_answer);
               ((TextView) findViewById(R.id.incorrect_answer1)).setText(wrong_answer1);
               ((TextView) findViewById(R.id.incorrect_answer2)).setText(wrong_answer2);
               Snackbar.make(findViewById(R.id.main_view),"Card successfully edited",Snackbar.LENGTH_SHORT).show();
           }
        }
    }
}
