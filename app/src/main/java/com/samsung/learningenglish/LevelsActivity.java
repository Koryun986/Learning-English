package com.samsung.learningenglish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LevelsActivity extends AppCompatActivity {
    private TextView btnBeginner;
    private TextView btnInermidiate;
    private TextView btnAdvanced;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);

        btnBeginner = findViewById(R.id.btn1);
        btnInermidiate = findViewById(R.id.btn3);
        btnAdvanced = findViewById(R.id.btn3);

        btnBeginner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LevelsActivity.this, BeginnerActivity.class);
                startActivity(i);
            }
        });
    }
}