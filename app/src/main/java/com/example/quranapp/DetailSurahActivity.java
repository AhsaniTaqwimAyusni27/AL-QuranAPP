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

        SurahModel surah = getIntent().getParcelableExtra("Surah");
        textViewID.setText(String.valueOf(surah.getId()));
    }
}