package com.example.thelast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageButton;

public class Inimigos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inimigos);

        ImageButton ib_voltar = findViewById(R.id.ib_voltar);
        ib_voltar.setOnClickListener(v -> {
            Intent voltarintent = new Intent(Inimigos.this,MainActivity.class);
            startActivity(voltarintent);
        });

    ImageButton btnspotify  = findViewById(R.id.btnspotify);
        btnspotify.setOnClickListener(v -> {

            Uri uri = Uri.parse("https://open.spotify.com/intl-pt/track/0U0ldCRmgCqhVvD6ksG63j?si=862bf6d6c68d42ce");
            Intent spotify = new Intent(Intent.ACTION_VIEW, uri);


            startActivity(spotify);

        });

    }
}