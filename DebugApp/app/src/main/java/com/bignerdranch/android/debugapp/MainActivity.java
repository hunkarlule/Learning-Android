package com.bignerdranch.android.debugapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private EditText e1, e2;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.edit1);
        e2 = findViewById(R.id.edit2);
        tv1 = findViewById(R.id.myresult);
    }

    public void doAdd(View view) {
        Log.i(TAG, "Executed1");
        int i1 = Integer.parseInt(e1.getText().toString());
        Log.i(TAG, "Executed2");
        int i2 = Integer.parseInt(e2.getText().toString());
        Log.i(TAG, "Executed3");
        int result = i1 + i2;
        Log.i(TAG, "Executed4");
        //tv1.setText(result); for debug purpose
          tv1.setText(String.valueOf(result));
        Log.i(TAG, "Executed5");
    }
}
