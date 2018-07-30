package com.sriyanksiddhartha.fragmentdemo;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Author: Sriyank Siddhartha
 *
 * 		Module 5 : Sending Data to a Fragment from Parent Activity
 *
 * 		METHOD 2 : Using fragment object along with custom method
 *
 * 		"BEFORE" Demo Project
 * */
public class MainActivity extends AppCompatActivity {

	private static final String TAG = MainActivity.class.getSimpleName();

	private FragmentManager manager;
	private EditText etFirstNumber, etSecondNumber;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		etFirstNumber = (EditText) findViewById(R.id.etFirstNumber);
		etSecondNumber = (EditText) findViewById(R.id.etSecondNumber);

		manager = getFragmentManager();
	}

	public void sendDataToFragment(View view) {

		FragmentA fragmentA = new FragmentA();

		FragmentTransaction transaction = manager.beginTransaction();
		transaction.add(R.id.containerFragmentA, fragmentA, "fragA");
		transaction.commit();
	}
}
