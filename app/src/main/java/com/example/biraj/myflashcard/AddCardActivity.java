package com.example.biraj.myflashcard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class AddCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        findViewById(R.id.cancel_card).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(AddCardActivity.this, MainActivity.class);
                startActivity(in);
                setResult(RESULT_CANCELED);
                finish();
                }
        });

        findViewById(R.id.save_card).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent updateFlashcard = new Intent(AddCardActivity.this, MainActivity.class);
                String text1 = ((EditText) findViewById(R.id.edittext1)).getText().toString();
                String text2 = ((EditText) findViewById(R.id.edittext2)).getText().toString();

                updateFlashcard.putExtra("question", text1);
                updateFlashcard.putExtra("answer", text2);
                setResult(RESULT_OK, updateFlashcard);
                startActivity(updateFlashcard);
                Log.i("Biraj", "This button was clicked!");
                finish();
            }
        });
        }
}
