package com.example.monsterinc;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.constraint.ConstraintSet;

import android.view.Display;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class GameView extends View {

    Rect rect, rect1;
    public static int dWidth, dHeight, returnWidth, moveWidth;

    Handler handler;
    Runnable runnable;
    final long UPDATE_MILLIS = 80;
    int playerFrame;
    int velocityUp, moveUp, left, left1, counter, range;
    boolean move, jumpClick;
    Player player;
    Buttons jumpButton;
    Background background;
    Health health;
    Music music;

    boolean startMusic;



    //default constructor
    public GameView(Context context){

        super (context);

        range = 200;
        player = new Player(context);
        jumpButton = new Buttons(context);
        background = new Background(context);
        health = new Health(context);
        music = new Music(context);
        startMusic = true;
        Display display = ((Activity)getContext()).getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        dWidth = size.x;
        dHeight = size.y;
        System.out.println("dWidth = " + dWidth);
        System.out.println("dHeight = " + dHeight);
        left = 0;
        returnWidth = dWidth;
        moveWidth = 0;
        playerFrame = 0;

        left1 = dWidth* -1;
        rect = new Rect(left,0,dWidth,dHeight);
        rect1 = new Rect(left,0,0,dHeight);
       // background = new Background(context);



        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                invalidate();
            }
        };
    }

    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        //jumpButton(canvas);
        background(canvas);
        player(canvas);
        jumpButton(canvas);
        healthBar(canvas);




        //music.playNinjaMusic();
        /*dWidth = dWidth - 20;
        left = left - 20;

        if(dWidth <= 0) {
            dWidth = returnWidth;
            left = 0;
            left1 = returnWidth * -1;

        }*/

        handler.postDelayed(runnable,UPDATE_MILLIS);
    }



    private void player(Canvas canvas){

        if(jumpClick == false) {
            canvas.drawBitmap(player.getBitmap(playerFrame), 100,
                    (dHeight / 2 - player.playerWidth / 2 + 43), null
            );
        }
        else if(jumpClick == true) {

            canvas.drawBitmap(player.getBitmap(6), 100,
                    (dHeight / 2) - range, null
            );
        }

        playerFrame++;
        moveWidth = moveWidth + 20;
        dWidth = dWidth - 20;
        if(dWidth <= 0) {
            moveWidth = 0;
            dWidth = returnWidth;
        }

        if(playerFrame == 6){
            playerFrame = 0;
        }
    }


    private void jumpButton(Canvas canvas){

        if(jumpClick == false) {
            canvas.drawBitmap(jumpButton.getJumpBitmap(), 100,
                    dHeight - 300, null);
        }
        else if(jumpClick == true){
            jumpButton.jumpButtonClicked();
            canvas.drawBitmap(jumpButton.getJumpBitmap(), 100,
                    dHeight - 300, null);

            counter++;
            if(counter == 6) {
                jumpButton.returnSize();
                jumpClick = false;
                counter = 0;
                range = 200;
            }else if(counter == 4){
                range = 400;
            }else if(counter == 3) {
                range = 350;
            }
            else if(counter == 2){
                range = 300;
            }
            else if(counter == 1){
                range = 250;
            }


        }
    }

    private void healthBar(Canvas canvas){
        canvas.drawBitmap(health.getRedHeart(),100, 100, null);
        canvas.drawBitmap(health.getRedHeart(),300, 100, null);
        canvas.drawBitmap(health.getRedHeart(),500, 100, null);
    }


    private void background(Canvas canvas){
        rect = new Rect(left - moveWidth,0,returnWidth - moveWidth,dHeight);
        int ok = returnWidth - moveWidth;
        rect1  = new Rect(ok,0,returnWidth + ok,dHeight);

        canvas.drawBitmap(background.getBitmap(), null, rect, null);

        canvas.drawBitmap(background.getBitmap(),null,rect1, null);
    }

    //this is when the user clicks the screen
    public boolean onTouchEvent(MotionEvent event)
    {
        //get the location of the click
        float touchX = event.getX();
        float touchY = event.getY();
        int action = event.getAction();

        if(touchX >= (120 - jumpButton.getJumpButtonWidth()/2) &&
                touchX <= (120 + jumpButton.getJumpButtonWidth()/2)
                && touchY <= (dHeight - jumpButton.getJumpButtonHeight())){
            jumpClick = true;
            if(counter == 0){
                music.playNinjaMusic();
            }
            System.out.println("Jump");
        }
        return true;

    }

}
