package com.sriyanksiddhartha.fragmentdemo;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Author : Sriyank Siddhartha
 * Module 4: Playing Around with Fragment Transaction.
 *
 *  	""BEFORE"" Demo app.
 * */
public class MainActivity extends AppCompatActivity {

	private static final String TAG = MainActivity.class.getSimpleName();

	private FragmentManager manager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		manager = getFragmentManager();
	}

	public void addFragmentA(View view) {

	}

	public void removeFragmentA(View view) {

	}

	public void addFragmentB(View view) {

	}

	public void removeFragmentB(View view) {

	}

	public void replaceByFragmentA(View view) {

	}

	public void replaceByFragmentB(View view) {

	}

	public void attachFragmentA(View view) {

	}

	public void detachFragmentA(View view) {

	}

	public void showFragmentA(View view) {

	}

	public void hideFragmentA(View view) {

	}
}
