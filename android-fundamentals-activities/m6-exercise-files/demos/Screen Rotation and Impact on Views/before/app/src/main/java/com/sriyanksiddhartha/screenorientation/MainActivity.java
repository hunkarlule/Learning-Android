package com.sriyanksiddhartha.screenorientation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * A Demo app to illustrate :
 * 		1. Activity Lifecycle behaviour on Screen Rotation
 * 		2. Impact of Screen Rotation on Views.
 * */
public class MainActivity extends AppCompatActivity {

	private static final String TAG = MainActivity.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Log.i(TAG, "onCreate()");
	}
}
