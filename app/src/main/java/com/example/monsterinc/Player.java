package com.example.monsterinc;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Player {

    public Bitmap player[] = new Bitmap[15];
    public int playerWidth, playerHeight, playerFrame;

    public Player(Context context){

        player[0] = BitmapFactory.decodeResource(context.getResources(),R.drawable.player_run_1);
        player[1] = BitmapFactory.decodeResource(context.getResources(),R.drawable.player_run_2);
        player[2] = BitmapFactory.decodeResource(context.getResources(),R.drawable.player_run_3);
        player[3] = BitmapFactory.decodeResource(context.getResources(),R.drawable.player_run_4);
        player[4] = BitmapFactory.decodeResource(context.getResources(),R.drawable.player_run_5);
        player[5] = BitmapFactory.decodeResource(context.getResources(),R.drawable.player_run_6);
        player[6] = BitmapFactory.decodeResource(context.getResources(),R.drawable.player_jump);

        player[0] = Bitmap.createScaledBitmap(player[0], 300,300,true);
        player[1] = Bitmap.createScaledBitmap(player[1], 300,300,true);
        player[2] = Bitmap.createScaledBitmap(player[2], 300,300,true);
        player[3] = Bitmap.createScaledBitmap(player[3], 300,300,true);
        player[4] = Bitmap.createScaledBitmap(player[4], 300,300,true);
        player[5] = Bitmap.createScaledBitmap(player[5], 300,300,true);
        player[6] = Bitmap.createScaledBitmap(player[6], 300,300,true);
    }


    public Bitmap getBitmap(int frame){
        return player[frame];
    }

    public int getWidth(){return player[0].getWidth();}

    public int getHeight(){return player[0].getHeight();}

}
