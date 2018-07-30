package com.bignerdranch.android.mybroadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class BroadcastInbuilt extends BroadcastReceiver {

    public BroadcastInbuilt() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("BroadcastInbuilt", "XXXXXXXXXXXXX");
        Toast.makeText(context, "Battery is low, please charge!", Toast.LENGTH_LONG).show();
    }
}
