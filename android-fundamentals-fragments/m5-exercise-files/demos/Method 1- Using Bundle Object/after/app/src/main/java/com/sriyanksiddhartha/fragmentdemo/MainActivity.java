package com.sriyanksiddhartha.fragmentdemo;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Author : Sriyank Siddhartha
 *
 * Module 5 : Sending Data to a Fragment from Parent Activity
 *
 * 		METHOD 1 : Using Bundle Object.
 *
 * 		"AFTER" demo project
 *
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

		int firstNumber = Integer.valueOf(etFirstNumber.getText().toString());
		int secondNumber = Integer.valueOf(etSecondNumber.getText().toString());

		// Using Bundle Object to send data from Activity to a Fragment
		Bundle bundle = new Bundle();
		bundle.putInt(Constants.FIRST_NUM, firstNumber);
		bundle.putInt(Constants.SECOND_NUM, secondNumber);

		FragmentA fragmentA = new FragmentA();
		fragmentA.setArguments(bundle);

		FragmentTransaction transaction = manager.beginTransaction();
		transaction.add(R.id.containerFragmentA, fragmentA, "fragA");
		transaction.commit();
	}
}
