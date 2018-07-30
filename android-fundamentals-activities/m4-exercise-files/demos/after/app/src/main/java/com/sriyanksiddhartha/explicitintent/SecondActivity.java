package com.sriyanksiddhartha.explicitintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

	private static final String TAG = SecondActivity.class.getSimpleName();

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);

		TextView textView = (TextView) findViewById(R.id.textView);

		StringBuilder msg = new StringBuilder("Welcome \n");

		Intent intent = getIntent();        // Get the reference to the incoming Intent object.
		Bundle b = intent.getExtras();      // Extract the Bundle residing inside the Intent.

		if (b.containsKey(Constants.KEY_NAME)) { // Just to be Safe
			String name = b.getString(Constants.KEY_NAME, "my default name");
			msg.append(name);
			Log.i(TAG, "Name : " + name);
		}

		if (b.containsKey(Constants.KEY_AGE)) { // Just to be safe
			int age = b.getInt(Constants.KEY_AGE, 30);
			msg.append("\n").append(age).append(" years old");
			Log.i(TAG, "Age : " + age);
		}

		assert textView != null;
		textView.setText(msg);      // Print the value on screen by using the TextView.
	}
}
