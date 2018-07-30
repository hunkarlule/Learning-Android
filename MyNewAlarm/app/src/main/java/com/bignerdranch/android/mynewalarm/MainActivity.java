package com.bignerdranch.android.mynewalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private AlarmManager mAlarmManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAlarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
    }

    public void startSomething(View view) {
        Toast.makeText(this, "Alarm STARTED!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent();
        intent.setAction("com.bignerdranch.myown.receiver.Message" );
        intent.addCategory("android.intent.category.DEFAULT");

        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);

        mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(),1000 * 30, pendingIntent);
    }

    public void stopSomething(View view) {
        Intent intent = new Intent();
        intent.setAction("com.bignerdranch.myown.receiver.Message" );
        intent.addCategory("android.intent.category.DEFAULT");

        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);

        mAlarmManager.cancel(pendingIntent);
        Toast.makeText(this, "Alarm Stopped!", Toast.LENGTH_SHORT).show();

    }
}
