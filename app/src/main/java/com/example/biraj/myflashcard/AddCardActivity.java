package com.example.biraj.myflashcard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        String  question = getIntent().getStringExtra("question");
        String  correct_answer = getIntent().getStringExtra("correct_answer");
        String  wrong_answer1 = getIntent().getStringExtra("incorrect_answer1");
        String  wrong_answer2 = getIntent().getStringExtra("incorrect_answer2");

        ((EditText) findViewById(R.id.question)).setText(question);
        ((EditText) findViewById(R.id.correct_answer)).setText(correct_answer);
        ((EditText) findViewById(R.id.wrong_answer1)).setText(wrong_answer1);
        ((EditText) findViewById(R.id.wrong_answer2)).setText(wrong_answer2);

        findViewById(R.id.cancel_card).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

        findViewById(R.id.save_card).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String question = ((EditText) findViewById(R.id.question)).getText().toString();
                String correct_answer = ((EditText) findViewById(R.id.correct_answer)).getText().toString();
                String wrong_answer1 = ((EditText) findViewById(R.id.wrong_answer1)).getText().toString();
                String wrong_answer2 = ((EditText) findViewById(R.id.wrong_answer2)).getText().toString();

                if(question.length() == 0 || correct_answer.length() == 0 || wrong_answer1.length() == 0 || wrong_answer2.length() == 0){
                    Toast.makeText(getApplicationContext(), "Must enter all question and answer.", Toast.LENGTH_SHORT).show();
                }else {
                    Intent data = new Intent();
                    data.putExtra("question", question);
                    data.putExtra("correct_answer", correct_answer);
                    data.putExtra("wrong_answer1", wrong_answer1);
                    data.putExtra("wrong_answer2", wrong_answer2);
                    setResult(RESULT_OK, data);
                    finish();
                }
            }
        });
    }
}

