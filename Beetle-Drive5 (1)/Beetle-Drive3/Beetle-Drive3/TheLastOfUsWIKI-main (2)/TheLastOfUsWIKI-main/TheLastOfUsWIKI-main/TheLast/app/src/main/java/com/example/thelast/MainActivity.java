package com.example.thelast;

import android.content.Intent;
import android.os.Bundle;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageButton ib_enredo = findViewById(R.id.ib_enredo);
        ib_enredo.setOnClickListener(v -> {
            Intent enredointent = new Intent(MainActivity.this,Enredo.class);
            startActivity(enredointent);
        });
        ImageButton ib_inimigo = findViewById(R.id.ib_inimigo);
        ib_inimigo.setOnClickListener(v -> {
            Intent inimigointent = new Intent(MainActivity.this,Inimigos.class);
            startActivity(inimigointent);
        });
        ImageButton ib_gameplay = findViewById(R.id.ib_gameplay);
        ib_gameplay.setOnClickListener(v -> {
            Intent gameplayintent = new Intent(MainActivity.this,Gameplay.class);
            startActivity(gameplayintent);
        });


    }
}
