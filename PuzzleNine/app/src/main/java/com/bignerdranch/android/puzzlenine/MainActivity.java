package com.bignerdranch.android.puzzlenine;

import android.graphics.PointF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mTextView;
    public static final String TAG= MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.textview8);

        mTextView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                float dX = 0;
                float dY = 0;
                switch (event.getAction()) {

                    case MotionEvent.ACTION_DOWN:

                        dX = v.getX();
                        dY = v.getY();
                        Log.d(TAG, Float.toString(dX));
                        Log.d(TAG, Float.toString(dY));
                        break;

                    case MotionEvent.ACTION_MOVE:

                        v.setX(0);
                        v.setX(0);

                        dX = v.getX();
                        dY = v.getY();
                        Log.d(TAG, Float.toString(dX));
                        Log.d(TAG, Float.toString(dY));
                        break;
                    default:
                        return false;
                }
                return true;


            }
        });
    }
}
