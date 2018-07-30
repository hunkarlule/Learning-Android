package com.sriyanksiddhartha.eventhandlingmethod3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

/**
 * Method 3 : Using onClick Attribute from XML layout to Trigger an Event.
 * */
public class MainActivity extends AppCompatActivity {

	private static final String TAG = MainActivity.class.getSimpleName();

	private RelativeLayout relativeLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
	}
}
