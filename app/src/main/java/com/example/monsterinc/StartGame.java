package com.example.monsterinc;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

public class StartGame extends Activity {

    GameView gameView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //for no title screen
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //to set it full screen
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        gameView = new GameView(StartGame.this);

        setContentView(gameView);
        //test = new TestClass(StartGame.this);
        // setContentView(test);
    }
}