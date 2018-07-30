package com.bignerdranch.android.mybroadcastreceiverdemo2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.widget.Toast;

public class MyCustomBroadcast01 extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        PackageManager pm = context.getPackageManager();
        Intent launchIntent = pm.getLaunchIntentForPackage("com.bignerdranch.android.mybroadcastreceiverdemo2");
        launchIntent.putExtra("some_data", "value");
        context.startActivity(launchIntent);
    }
}
