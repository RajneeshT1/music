package com.acadview.services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

public  class Myservices extends Service {

    MediaPlayer myplayer;
    int length = 0;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        myplayer = myplayer.create(this, R.raw.my);
        myplayer.setLooping(true);
        Toast.makeText(this, "service created", Toast.LENGTH_SHORT).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(intent.getStringExtra("order").equalsIgnoreCase("play")) {
            myplayer.start();
            myplayer.setLooping(true);

        }
        else if(intent.getStringExtra("order").equals("pause")){
            length=myplayer.getCurrentPosition();
            myplayer.pause();
        }
        else if(intent.getStringExtra("order").equalsIgnoreCase("resume")){
            myplayer.seekTo(length);
            myplayer.start();
        }

        return START_STICKY;
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        myplayer.stop();
    }
}
