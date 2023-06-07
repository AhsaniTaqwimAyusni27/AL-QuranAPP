package com.example.quranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailSurahActivity extends AppCompatActivity {

    TextView textViewID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_surah);

        textViewID = findViewById(R.id.tvIDSurah);

        int id = getIntent().getIntExtra("id", 1);
        textViewID.setText(String.valueOf(id));
    }
}