package com.example.hafzaoyunu;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class OyunEkrani extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    int sonKart=0;
    int skor=0;
    int hata=0;
    card k2;
    card k;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_oyun_ekrani);
        Intent i = getIntent();
        final String s=i.getStringExtra("mesaj");

        TextView tv = findViewById(R.id.oyunekranı_isim);
        tv.setText("En az hatayla eşleri bulmaya çalışmalısın! "+s);
        GridLayout gl= findViewById(R.id.gridLayout);

        final card kartlar [] = new card[16];



        for (int j=1;j<=16;j++) {
            kartlar[j-1] = new card(this, j);
            kartlar[j-1].setOnClickListener(new View.OnClickListener() {

                @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public void onClick(View v) {
                    k = (card ) v;
                    k.cevir();
                    if (sonKart>0){
                         k2 = (card) findViewById(sonKart);

                        if (k2.onPlanID==k.onPlanID && k2.getId()!=k.getId()){
                            //eşleştirler
                            k2.cevirilebilir=false;
                            k.cevirilebilir=false;
                            skor++;
                            TextView tv = findViewById(R.id.skor);
                            tv.setText("Skorunuz: "+skor);
                            sonKart=0;
                            if (skor==8){
                                //oyun bitti
                                Intent i=new Intent(OyunEkrani.this,FinalEkran.class);
                                i.putExtra("puan",hata);
                                i.putExtra("isim",s);
                                startActivity(i);

                            }
                        }else{
                         //eşleşmedilre geri çevir 2 kartıda
                            Handler h = new Handler();
                            h.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    k2.cevir();
                                    k.cevir();
                                }
                            },500);
                            hata++;

                            TextView tv = findViewById(R.id.hata);
                            tv.setText("Hata sayınız: "+hata);
                            sonKart=0;
                        }
                    }
                    else{
                        sonKart=k.getId();
                    }
                }
            });
        }

        //Karıştır

        for (int j=0;j<16;j++){
            int random = (int) (Math.random()*16);
            card k = kartlar[random];
            kartlar[random]=kartlar[j];
            kartlar[j]=k;
        }

        for (int j=0;j<16;j++){
            gl.addView(kartlar[j]);
        }
    }

}
