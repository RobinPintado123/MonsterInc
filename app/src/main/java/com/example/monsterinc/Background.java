package com.example.monsterinc;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Background {

    Bitmap background;

    public Background(Context context){

        background = BitmapFactory.decodeResource(context.getResources(), R.drawable.background);

    }


    public Bitmap getBitmap(){
        return background;
    }

    public int getWidth(){return background.getWidth();}

    public int getHeight(){return background.getHeight();}
}
