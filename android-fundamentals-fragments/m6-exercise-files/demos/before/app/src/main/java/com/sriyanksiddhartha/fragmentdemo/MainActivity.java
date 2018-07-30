package com.sriyanksiddhartha.fragmentdemo;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Author : Sriyank Siddhartha
 *
 * 		Module 6: Understanding Communication Flow from Fragment to Activity
 *
 * 		"BEFORE" Demo Project
 * */
public class MainActivity extends AppCompatActivity {

	private static final String TAG = MainActivity.class.getSimpleName();

	private FragmentManager manager;
	private TextView txvResult;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		txvResult = (TextView) findViewById(R.id.txvResult);

		manager = getFragmentManager();
		addFragmentA();
	}

	public void addFragmentA() {

		FragmentA fragmentA = new FragmentA();
		FragmentTransaction transaction = manager.beginTransaction();
		transaction.add(R.id.containerFragmentA, fragmentA, "fragA");
		transaction.commit();
	}
}
