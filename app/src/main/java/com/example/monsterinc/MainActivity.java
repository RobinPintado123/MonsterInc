package com.example.monsterinc;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static MediaPlayer music;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        music = MediaPlayer.create(MainActivity.this, R.raw.ninja);
        music.setLooping(false);
        //music.start();
        //setContentView(new GameView(this));
    }

    public MediaPlayer getMusic(){
        music = MediaPlayer.create(MainActivity.this, R.raw.ninja);
        music.setLooping(false);
        music.start();
        return music;
    }

    //this is the script when user press start game
    public void startGame(View view){
        //this will change screen from Main activity to start Game
        Intent intent = new Intent(MainActivity.this, StartGame.class);

        startActivity(intent);
        finish();
    }
}
