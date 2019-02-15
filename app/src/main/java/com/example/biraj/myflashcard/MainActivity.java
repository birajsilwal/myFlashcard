package com.example.biraj.myflashcard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.flashcard_question).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                findViewById(R.id.flashcard_answer).setVisibility(View.VISIBLE);
                findViewById(R.id.flashcard_question).setVisibility(View.INVISIBLE);
            }

        });

        findViewById(R.id.add_card).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent createCard = new Intent(MainActivity.this, AddCardActivity.class);
                startActivityForResult(createCard,100);
                //startActivity(createCard);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            //Intent intent = getIntent();
            String question = data.getStringExtra("question");
            String answer = data.getStringExtra("answer");


            TextView flashcard_question = (TextView) findViewById(R.id.flashcard_question);
            TextView flashcard_answer = (TextView) findViewById(R.id.flashcard_answer);

            flashcard_question.setText(question);
            flashcard_answer.setText(answer);
    }
}

