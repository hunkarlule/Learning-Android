package com.bignerdranch.android.mynewalarm;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.widget.Toast;

public class StandUp extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Inside Receiver", Toast.LENGTH_SHORT).show();

        NotificationManagerCompat myManager = NotificationManagerCompat.from(context);
        NotificationCompat.Builder myNotificationBuilder = new NotificationCompat.Builder(context);

        myNotificationBuilder.setContentTitle("Stand Up Notification!");
        myNotificationBuilder.setContentText("You should stand up!");
        myNotificationBuilder.setSmallIcon(android.R.drawable.ic_btn_speak_now);

        Intent myIntent = new Intent(context, StandUpActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, myIntent, 0);
        myNotificationBuilder.setContentIntent(pendingIntent);
        myNotificationBuilder.setAutoCancel(true);
        myManager.notify(1, myNotificationBuilder.build());

    }
}
