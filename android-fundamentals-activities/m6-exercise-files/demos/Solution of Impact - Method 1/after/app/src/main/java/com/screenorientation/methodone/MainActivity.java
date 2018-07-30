package com.screenorientation.methodone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A Demo app to illustrate SOLUTION:
 * 		1. How to restore Activity State back
 * 		   to it's previous state before screen rotation using onRestoreInstanceState
 * 		   and onSaveInstanceState methods.
 * 		2. How to update the Resources as well.
 * */
public class MainActivity extends AppCompatActivity {

	private final String TAG = MainActivity.class.getSimpleName();

	private TextView txvMessage;
	private EditText etName;
	private Button btnSubmit;

	private final String KEY_MESSAGE = "message";
	private final String KEY_BTN_TEXT = "button_text";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.i(TAG, "onCreate()");

		etName = (EditText) findViewById(R.id.etName);
		txvMessage = (TextView) findViewById(R.id.txvMessage);
		btnSubmit = (Button) findViewById(R.id.btnSubmit);

		btnSubmit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				txvMessage.setText("Welcome " + etName.getText().toString());
				btnSubmit.setText("LOGOUT");
			}
		});
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);

		Log.i(TAG, "onRestoreInstanceState()");

		if (savedInstanceState != null) {
			btnSubmit.setText(savedInstanceState.getString(KEY_BTN_TEXT));
			txvMessage.setText(savedInstanceState.getString(KEY_MESSAGE));
		}
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		Log.i(TAG, "onSaveInstanceState()");

		outState.putString(KEY_MESSAGE, txvMessage.getText().toString());
		outState.putString(KEY_BTN_TEXT, btnSubmit.getText().toString());
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		Log.i(TAG, "onRestart()");
	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.i(TAG, "onStart()");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.i(TAG, "onResume()");
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.i(TAG, "onPause()");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.i(TAG, "onStop()");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.i(TAG, "onDestroy()");
	}
}
