package com.sriyanksiddhartha.fragmentdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Author : Sriyank Siddhartha
 * Module 2: Adding the Fragment to an Activity.
 *
 *		1. Adding Fragment via XML
 *  	""BEFORE"" Demo app.
 **/
public class MainActivity extends AppCompatActivity {

	private final static String TAG = MainActivity.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}
}
