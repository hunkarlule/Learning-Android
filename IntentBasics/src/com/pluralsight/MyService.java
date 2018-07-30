package com.pluralsight;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by IntelliJ IDEA.
 * User: Jim
 * Date: 8/25/11
 * Time: 2:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class MyService extends Service {
    int _callCount;

    final int _notificationId = 1;

    @Override
    public void onCreate() {
        Log.i("MyService", "onCreate");
        _callCount = 0;
        startInForeground();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // ** When working in real life, never do work directly on the
        //    service's main thread (it's the same thread that the UI uses).
        _callCount++;
        Log.i("MyService", "onStartCommand - call #" + _callCount);
        return START_NOT_STICKY;
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    void startInForeground(){
        // Set basic notification information
        int notificationIcon = R.drawable.ps24x24;
        String notificationTickerText = "Launching pluralsight service";
        long notificationTimeStamp = System.currentTimeMillis();
        Notification foregroundNotification = new Notification(notificationIcon,
            notificationTickerText, notificationTimeStamp);

        // Describe what to do if the user clicks the notification in the status bar
        String notificationTitleText = "Pluralsight service";
        String notificationBodyText = "Does non-UI processing";
        Intent notificationActivityIntent = createNotificationActivityIntent();
        PendingIntent startMyActivityPendingIntent = PendingIntent.getActivity(this, 0, notificationActivityIntent, 0);
        foregroundNotification.setLatestEventInfo(this, notificationTitleText, notificationBodyText, startMyActivityPendingIntent);

        // ID to use w/ Notification Manager for _foregroundNotification
        // Set the service to foreground status and provide notification info
        startForeground(_notificationId, foregroundNotification);

    }

    private Intent createNotificationActivityIntent(){
        Intent myActivityIntent = null;
        return myActivityIntent;
    }

}
