package com.bignerdranch.android.eventhandlingmethod3;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    private RelativeLayout mRelativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRelativeLayout = findViewById(R.id.relativeLayout);
    }

    public void changeToGreen(View view) {
        mRelativeLayout.setBackgroundColor(Color.GREEN);
    }

    public void changeToBlue(View view) {
        mRelativeLayout.setBackgroundColor(Color.BLUE);
    }
}
