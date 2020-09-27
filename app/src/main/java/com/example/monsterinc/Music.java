package com.example.monsterinc;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Music {

    private static SoundPool soundPool;
    private static int ninjaSound;

    public Music(Context context){
       soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        ninjaSound = soundPool.load(context, R.raw.ninjajump, 1);

    }



    public void playNinjaMusic(){
        soundPool.play(ninjaSound,1.0f,1.0f, 0,0,1.5f);
    }

}


