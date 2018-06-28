package com.acadview.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals("TIME CHANGED"))
        Toast.makeText(context,"Broadcast receiver",Toast.LENGTH_SHORT).show();
    }
}
