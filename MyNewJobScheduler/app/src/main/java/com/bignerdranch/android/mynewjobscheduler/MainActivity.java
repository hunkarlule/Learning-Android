package com.bignerdranch.android.mynewjobscheduler;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    private ToggleButton mToggleButton;
    private JobScheduler mJobScheduler;
    private JobInfo mJobInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToggleButton = findViewById(R.id.myjobbutton);

        mToggleButton.setOnCheckedChangeListener(this);
        mJobScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {

            JobInfo.Builder myJobBuilder = new JobInfo.Builder(1, new ComponentName(getPackageName(), MyNewJobService.class.getName()))
                    .setRequiresCharging(true)
                    .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
                    .setRequiresDeviceIdle(false);

            mJobInfo = myJobBuilder.build();
            mJobScheduler.schedule(mJobInfo);

        } else {
           mJobScheduler.cancelAll();
        }
    }
}
