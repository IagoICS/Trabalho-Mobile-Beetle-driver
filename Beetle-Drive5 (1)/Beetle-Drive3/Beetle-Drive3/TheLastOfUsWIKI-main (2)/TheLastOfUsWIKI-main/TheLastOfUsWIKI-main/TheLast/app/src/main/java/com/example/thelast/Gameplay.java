package com.example.thelast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageButton;

public class Gameplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplay);

        ImageButton ib_voltar = findViewById(R.id.ib_voltar);
        ib_voltar.setOnClickListener(v -> {
            Intent voltarintent = new Intent(Gameplay.this,MainActivity.class);
            startActivity(voltarintent);
        });

        ImageButton btnyoutube = findViewById(R.id.btnyoutube);
        btnyoutube.setOnClickListener(v -> {

            Uri uri = Uri.parse("https://youtu.be/BEa3T2DF4N8");
            Intent youtube = new Intent(Intent.ACTION_VIEW, uri);


            startActivity(youtube);

        });

    }
}