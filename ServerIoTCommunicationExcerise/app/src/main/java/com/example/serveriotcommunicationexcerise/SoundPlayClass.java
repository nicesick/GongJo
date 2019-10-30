package com.example.serveriotcommunicationexcerise;

import android.app.Activity;
import android.media.AudioManager;
import android.media.SoundPool;

public class SoundPlayClass {
    SoundPool soundPool;
    int rightAlarm;
    int leftAlarm;
    int dangerAreaAlarm;
    static Activity context;

    public SoundPlayClass(){
        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC,0);
        rightAlarm = soundPool.load(context,R.raw.right_seat_belt,1);
        leftAlarm = soundPool.load(context,R.raw.left_seat_belt,1);
//        dangerAreaAlarm = soundPool.load(context,)
    }
    public SoundPlayClass(Activity context) {
        this.context = context;
        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC,0);
        rightAlarm = soundPool.load(context,R.raw.right_seat_belt,1);
        leftAlarm = soundPool.load(context,R.raw.left_seat_belt,1);
    }
    public void playRightAlarm(){
        soundPool.play(rightAlarm,1,1,1,0,1);
    }
    public void playLeftAlarm(){
        soundPool.play(leftAlarm,1,1,2,0,1);
    }
}
