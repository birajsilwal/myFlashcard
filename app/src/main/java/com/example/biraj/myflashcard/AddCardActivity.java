package com.example.biraj.myflashcard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

    findViewById(R.id.cancel_card).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
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

                Intent data = new Intent();
                data.putExtra("question", question);
                data.putExtra("correct_answer", correct_answer);
                data.putExtra("wrong_answer1", wrong_answer1);
                data.putExtra("wrong_answer2", wrong_answer2);
                setResult(RESULT_OK, data);
                finish();
            }
        });



    }
}

