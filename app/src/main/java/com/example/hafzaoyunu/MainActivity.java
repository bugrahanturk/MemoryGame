package com.example.hafzaoyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String isim;
        final EditText et= findViewById(R.id.tf_isim);

        ((Button) findViewById(R.id.oyuna_basla)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,OyunEkrani.class);//activity başlatıyor!
                i.putExtra("mesaj",et.getText().toString());
                startActivity(i);
            }
        });






    }
}
