package com.example.quranapp;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quranapp.model.Chapters;
import com.example.quranapp.model.ChaptersItem;
import com.example.quranapp.retrofit.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityBackup extends AppCompatActivity {
    private final String TAG = "MainActivity";

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
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivityBackup.this));
        getDataFromApi();
    }

    private void getDataFromApi (){
        ApiService.endpoint().getSurah().enqueue(new Callback<Chapters>() {
            @Override
            public void onResponse(Call<Chapters> call, Response<Chapters> response) {
                if (response.isSuccessful()){
                    List<ChaptersItem> result = response.body().getChapters();
                    Log.d(TAG, result.toString());
                }
            }

            @Override
            public void onFailure(Call<Chapters> call, Throwable t) {
                Log.d(TAG, t.toString());
            }
        });
    }
}