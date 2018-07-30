package com.bignerdranch.android.servicesdemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyOwnService extends Service {
    public MyOwnService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this,"Service CREATED!",Toast.LENGTH_SHORT).show();
        Log.i("MyService","Service has CREATED");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this,"Service STARTED!",Toast.LENGTH_SHORT).show();
        Log.i("MyService","Service has STARTED");
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"Service STOPPED!",Toast.LENGTH_SHORT).show();
        Log.i("MyService","Service has STOPPED");
    }

    @Override
    public IBinder onBind(Intent intent) {
    return  null;
    }
}
