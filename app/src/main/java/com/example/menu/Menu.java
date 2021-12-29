package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;

public class Menu extends AppCompatActivity {

    TextView nom,speciality,adresse, tel;
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        nom = (TextView) findViewById(R.id.textView);
        nom.setText(getIntent().getStringExtra("le_nom_du_resto"));
        speciality = (TextView) findViewById(R.id.speciality);
        speciality.setText((getIntent().getStringExtra("la_speciality")));
        adresse = (TextView) findViewById(R.id.adresse);
        adresse.setText(getIntent().getStringExtra("l_adresse"));
        tel = (TextView) findViewById(R.id.tel);
        tel.setText(getIntent().getStringExtra("le_tel"));

    }
    @Override
    protected void onResume() {
        super.onResume();
        mediaPlayer = MediaPlayer.create(this,getIntent().getIntExtra("Category_music",0));
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }
    @Override
    protected void onStop() {
        super.onStop();
        mediaPlayer.stop();
    }
}