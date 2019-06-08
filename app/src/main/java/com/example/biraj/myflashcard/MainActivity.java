package com.example.biraj.myflashcard;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    static int ADD_CARD_REQUEST_CODE = 0;
    static int EDIT_CARD_REQUEST_CODE = 1;
    int currentCardDisplayedIndex = 0;

    FlashcardDatabase flashcardDatabase;
    List<Flashcard> allFlashcards;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flashcardDatabase = new FlashcardDatabase(getApplicationContext());
        allFlashcards = flashcardDatabase.getAllCards();

        //check if the database is empty or not
        if (allFlashcards != null && allFlashcards.size() > 0) {
            ((TextView) findViewById(R.id.flashcard_question)).setText(allFlashcards.get(0).getQuestion());
            ((TextView) findViewById(R.id.flashcard_answer)).setText(allFlashcards.get(0).getAnswer());
            ((TextView) findViewById(R.id.correct_answer)).setText(allFlashcards.get(0).getAnswer());
            ((TextView) findViewById(R.id.incorrect_answer1)).setText(allFlashcards.get(0).getWrongAnswer1());
            ((TextView) findViewById(R.id.incorrect_answer2)).setText(allFlashcards.get(0).getWrongAnswer2());
        }

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
                data.putExtra("question", ((TextView) findViewById(R.id.flashcard_question)).getText().toString());
                data.putExtra("correct_answer", ((TextView) findViewById(R.id.flashcard_answer)).getText().toString());
                data.putExtra("correct_answer", ((TextView) findViewById(R.id.correct_answer)).getText().toString());
                data.putExtra("incorrect_answer1", ((TextView) findViewById(R.id.incorrect_answer1)).getText().toString());
                data.putExtra("incorrect_answer2", ((TextView) findViewById(R.id.incorrect_answer2)).getText().toString());
                MainActivity.this.startActivityForResult(data, EDIT_CARD_REQUEST_CODE);
            }
        });


        findViewById(R.id.next_card).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // advance our pointer index so we can show the next card
                currentCardDisplayedIndex++;

                // make sure we don't get an IndexOutOfBoundsError if we are viewing the last indexed card in our list
                if (currentCardDisplayedIndex > allFlashcards.size() - 1) {
                    currentCardDisplayedIndex = 0;
                }

                // set the question and answer TextViews with data from the database
                ((TextView) findViewById(R.id.flashcard_question)).setText(allFlashcards.get(currentCardDisplayedIndex).getQuestion());
                ((TextView) findViewById(R.id.flashcard_answer)).setText(allFlashcards.get(currentCardDisplayedIndex).getAnswer());
                ((TextView) findViewById(R.id.correct_answer)).setText(allFlashcards.get(currentCardDisplayedIndex).getAnswer());
                ((TextView) findViewById(R.id.incorrect_answer1)).setText(allFlashcards.get(currentCardDisplayedIndex).getWrongAnswer1());
                ((TextView) findViewById(R.id.incorrect_answer2)).setText(allFlashcards.get(currentCardDisplayedIndex).getWrongAnswer2());
            }
        });

        findViewById(R.id.delete_card).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flashcardDatabase.deleteCard(((TextView) findViewById(R.id.flashcard_question)).getText().toString());
                allFlashcards = flashcardDatabase.getAllCards();
                currentCardDisplayedIndex--;
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       if(resultCode == RESULT_OK){
           String question = data.getExtras().getString("question");
           String correct_answer = data.getExtras().getString("correct_answer");
           String wrong_answer_1 = data.getExtras().getString("wrong_answer_1");
           String wrong_answer_2 = data.getExtras().getString("wrong_answer_2");
        if (requestCode == ADD_CARD_REQUEST_CODE) {

            flashcardDatabase.insertCard(new Flashcard(question, correct_answer, wrong_answer_1, wrong_answer_2));
            allFlashcards = flashcardDatabase.getAllCards();

            Snackbar.make(findViewById(R.id.main_view),"Card successfully created",Snackbar.LENGTH_SHORT).show();
        }
           if (requestCode == EDIT_CARD_REQUEST_CODE) {

               ((TextView) findViewById(R.id.flashcard_question)).setText(question);
               ((TextView) findViewById(R.id.flashcard_answer)).setText(correct_answer);
               ((TextView) findViewById(R.id.correct_answer)).setText(correct_answer);
               ((TextView) findViewById(R.id.incorrect_answer1)).setText(wrong_answer_1);
               ((TextView) findViewById(R.id.incorrect_answer2)).setText(wrong_answer_2);
               Snackbar.make(findViewById(R.id.main_view),"Card successfully edited",Snackbar.LENGTH_SHORT).show();
           }
        }
    }
}
