package com.sriyanksiddhartha.fragmentdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Author : Sriyank Siddhartha
 * Module 3: Exploring Fragment Lifecycle.
 *
 *  	""BEFORE"" Demo app.
 **/
public class MainActivity extends AppCompatActivity {

	private static final String TAG = MainActivity.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}
}
