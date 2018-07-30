package com.bignerdranch.android.eventhandlingactivity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = MainActivity.class.getSimpleName();
    private RelativeLayout mRelativeLayout;
    private Button mButton1;
    private Button mButton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRelativeLayout = findViewById(R.id.relativeLayout);
        mButton1 = findViewById(R.id.button1);
        mButton2 = findViewById(R.id.button2);

        mButton1.setOnClickListener(MainActivity.this);
        mButton2.setOnClickListener(MainActivity.this);

    }

    @Override
    public void onClick(View view) {
        Log.i(TAG, "button clicked");

        switch(view.getId()) {
            case R.id.button1:
                Log.i(TAG, "color changed to green");
mRelativeLayout.setBackgroundColor(Color.GREEN);
break;
            case R.id.button2:
                Log.i(TAG, "color changed to blue");

                mRelativeLayout.setBackgroundColor(Color.BLUE);
                break;


        }

    }
}
