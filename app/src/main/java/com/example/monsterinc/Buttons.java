package com.example.monsterinc;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Buttons {

    Bitmap jumpButton;

    public Buttons(Context context){
        jumpButton = BitmapFactory.decodeResource(context.getResources(), R.drawable.jump);
        jumpButton = Bitmap.createScaledBitmap(jumpButton,200,200,true);
    }


    public Bitmap getJumpBitmap(){
        return jumpButton;
    }

    public void jumpButtonClicked(){
        jumpButton = Bitmap.createScaledBitmap(jumpButton,150,150,true);
    }

    public void returnSize(){
        jumpButton = Bitmap.createScaledBitmap(jumpButton,200,200,true);
    }

    public int getJumpButtonWidth()
    {
        return jumpButton.getWidth();
    }

    public int getJumpButtonHeight(){
        return jumpButton.getHeight();
    }
}
