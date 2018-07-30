package com.bignerdranch.android.explicitintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = SecondActivity.class.getSimpleName();
    private TextView mTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mTextView = findViewById(R.id.textView);

        StringBuilder msg = new StringBuilder("Welcome \n");

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if (bundle.containsKey(Constants.KEY_AGE)) {
            String name = bundle.getString(Constants.KEY_NAME, "my default name");
            Log.i(TAG, "Name: " + name);
            msg.append(name);
        }

        if (bundle.containsKey(Constants.KEY_AGE)) {
            int age = bundle.getInt(Constants.KEY_AGE, 0);
            Log.i(TAG, "Age: " + age);
            msg.append("\n").append(age).append(" years old");
        }

        mTextView.setText(msg);

    }
}
