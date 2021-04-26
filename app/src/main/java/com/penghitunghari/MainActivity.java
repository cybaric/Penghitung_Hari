package com.penghitunghari;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class MainActivity extends AppCompatActivity {
LinearLayout a, b, c, d;
Button ex, sim;
InterstitialAd in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        in = new InterstitialAd(MainActivity.this);
        in.setAdUnitId("ca-app-pub-9560479013051071/2009576314");
        AdRequest minta = new AdRequest.Builder().build();
        in.loadAd(minta);
        in.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded(){
                displayInterstitial();
            }
        });

        a = findViewById(R.id.duluk);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(getApplicationContext() ,MasaLalu.class);
                startActivity(a);
            }
        });

        b = findViewById(R.id.bsok);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(getApplicationContext() ,MasaDepan.class);
                startActivity(b);
            }
        });

        c = findViewById(R.id.umum);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(getApplicationContext() ,Masa.class);
                startActivity(c);
            }
        });

        d = findViewById(R.id.interv);
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent d = new Intent(getApplicationContext() ,Interval.class);
                startActivity(d);
            }
        });

        ex = findViewById(R.id.exit);
        ex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        sim = findViewById(R.id.simpan);
        sim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent e = new Intent(getApplicationContext() ,Tersimpan.class);
                startActivity(e);
            }
        });

    }
    public void  displayInterstitial(){
        if (in.isLoaded()){
            in.show();
        }
    }

}