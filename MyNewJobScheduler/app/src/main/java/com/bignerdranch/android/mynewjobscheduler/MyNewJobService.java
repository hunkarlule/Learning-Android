package com.bignerdranch.android.mynewjobscheduler;

import android.annotation.TargetApi;
import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyNewJobService extends JobService {
    public MyNewJobService() {
    }

    @Override
    public boolean onStartJob(JobParameters params) {
        Log.i("MyJobService","Job Started!");
        Toast.makeText(this,"Job Started", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        Log.i("MyJobService","Job Stopped!");
        Toast.makeText(this,"Job stopped", Toast.LENGTH_SHORT).show();
        return false;
    }


}
