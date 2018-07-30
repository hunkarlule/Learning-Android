package com.bignerdranch.android.screenrotationhandlingmethod1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private TextView mTextView;
    private Button mButton;
    private EditText mEditText;
    private final static String KEY_MESSAGE = "message";
    private final static String KEY_BUTTON_TEXT = "button_text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "onCreate");

        mTextView = findViewById(R.id.txvMessage);
        mEditText = findViewById(R.id.etName);
        mButton = findViewById(R.id.btnSubmit);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextView.setText("Welcome " + mEditText.getText().toString());
                mButton.setText("LOGOUT");
            }
        });

//        if(savedInstanceState != null) {
//            mButton.setText(savedInstanceState.getString(KEY_BUTTON_TEXT));
//            mTextView.setText(savedInstanceState.getString(KEY_MESSAGE));
//        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "onRestoreInstanceState");

        if (savedInstanceState != null) {
            mButton.setText(savedInstanceState.getString(KEY_BUTTON_TEXT));
            mTextView.setText(savedInstanceState.getString(KEY_MESSAGE));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState");

        outState.putString(KEY_MESSAGE, mTextView.getText().toString());
        outState.putString(KEY_BUTTON_TEXT, mButton.getText().toString());

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }
}
