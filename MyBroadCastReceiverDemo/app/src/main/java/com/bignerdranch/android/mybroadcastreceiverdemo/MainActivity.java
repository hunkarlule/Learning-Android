package com.bignerdranch.android.mybroadcastreceiverdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void callCustom(View view) {
        Intent intent = new Intent();
        intent.setAction("com.bignerdranch.own.MyReceiver.call");
        intent.addCategory("android.intent.category.DEFAULT");
        sendBroadcast(intent);
    }
}
