package com.sriyanksiddhartha.fragmentdemo;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Author : Sriyank Siddhartha
 *
 * 		Module 7 : Understanding Inter-fragment Communication
 *
 * 		"BEFORE" demo project
 *
 * 		Here we need to Pass data in this way : FragmentA --> MainActivity --> FragmentB.
 * */
public class MainActivity extends AppCompatActivity implements MyListener {

	private static final String TAG = MainActivity.class.getSimpleName();

	private FragmentManager manager;
	private int num1, num2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		manager = getFragmentManager();
		addFragmentA();
		addFragmentB();
	}

	public void addFragmentA() {

		FragmentA fragmentA = new FragmentA();
		FragmentTransaction transaction = manager.beginTransaction();
		transaction.add(R.id.containerFragmentA, fragmentA, "fragA");
		transaction.commit();
	}

	private void addFragmentB() {

		// Put your codes here..
	}

	@Override
	public void addTwoNumbers(int num1, int num2) {

		// Put your codes here..
	}

	public void sendDataToFragmentB(View view) {

		// Put your codes here..
	}
}
