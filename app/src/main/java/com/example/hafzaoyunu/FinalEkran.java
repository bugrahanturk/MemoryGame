package com.example.hafzaoyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class FinalEkran extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_ekran);
        TextView tv = findViewById(R.id.son);
        Intent i = getIntent();
        String isim=i.getStringExtra("isim");
        int score = i.getIntExtra("puan",0);
        tv.setText("Tebrikler "+isim+"\n"+score+" hata ile kazandınız");
    }
}
