package com.example.monsterinc;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Health {

    Bitmap redHeart, greyHeart;

    public Health(Context context){
        redHeart = BitmapFactory.decodeResource(context.getResources(), R.drawable.hearts);
        greyHeart = BitmapFactory.decodeResource(context.getResources(), R.drawable.heart_grey);
    }

    public Bitmap getRedHeart(){
        return redHeart;
    }

    public Bitmap getGreyHeart(){
        return greyHeart;
    }

}
