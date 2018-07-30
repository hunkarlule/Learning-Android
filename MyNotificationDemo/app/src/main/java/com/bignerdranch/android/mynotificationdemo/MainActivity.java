package com.bignerdranch.android.mynotificationdemo;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doSomething(View view) {
        NotificationManagerCompat myManager = NotificationManagerCompat.from(this);
        NotificationCompat.Builder myNotificationBuilder = new NotificationCompat.Builder(this);
        myNotificationBuilder.setContentTitle("! new message!");
        myNotificationBuilder.setContentText("Hi, how are you?");
        myNotificationBuilder.setSmallIcon(android.R.drawable.ic_btn_speak_now);

        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 1, intent, 0);
        myNotificationBuilder.setContentIntent(pendingIntent);
        myNotificationBuilder.setAutoCancel(true);
        myManager.notify(1, myNotificationBuilder.build());
        finish();
    }
}
