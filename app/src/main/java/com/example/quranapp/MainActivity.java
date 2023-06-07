package com.example.quranapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    AdapaterSurahs adapaterSurahs;
    ArrayList<SurahModel> objSurah = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        objSurah.add(new SurahModel(1, "Al-Fatihah", "الفاتحة",new TranslatedName("Pembukaan")));
        objSurah.add(new SurahModel(2, "Al-Fatihah", "الفاتحة",new TranslatedName("Pembukaan")));
        objSurah.add(new SurahModel(3, "Al-Fatihah", "الفاتحة",new TranslatedName("Pembukaan")));

        adapaterSurahs = new AdapaterSurahs(objSurah);
        recyclerView.setAdapter(adapaterSurahs);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }
}