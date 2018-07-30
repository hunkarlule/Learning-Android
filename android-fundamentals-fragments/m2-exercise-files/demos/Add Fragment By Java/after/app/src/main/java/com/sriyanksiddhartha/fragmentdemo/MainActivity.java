package com.sriyanksiddhartha.fragmentdemo;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Author : Sriyank Siddhartha
 * Module 2: Adding the Fragment to an Activity.
 *
 *		1. Adding Fragment via JAVA
 *  	""AFTER"" Demo app.
 **/
public class MainActivity extends AppCompatActivity {

	private static final String TAG = MainActivity.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		HelloFragment helloFragment = new HelloFragment();

		FragmentManager manager = getFragmentManager();
		FragmentTransaction transaction = manager.beginTransaction();
		transaction.add(R.id.container, helloFragment, "helloFragment");
		transaction.commit();
	}
}
