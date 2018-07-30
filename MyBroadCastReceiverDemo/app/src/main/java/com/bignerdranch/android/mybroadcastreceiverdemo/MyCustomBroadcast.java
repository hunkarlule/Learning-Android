package com.bignerdranch.android.mybroadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyCustomBroadcast extends BroadcastReceiver {
    public MyCustomBroadcast() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "First reciever called", Toast.LENGTH_SHORT).show();
    }
}
