package com.sriyanksiddhartha.fragmentdemo;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

/**
 * Author : Sriyank Siddhartha
 *
 * 		Module 8 : Enabling Back Button in Fragments using Back Stack
 *
 * 		"BEFORE" Demo project
 * */
public class MainActivity extends AppCompatActivity {

	private static final String TAG = MainActivity.class.getSimpleName();

	private FragmentManager manager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		manager = getFragmentManager();
//		manager.addOnBackStackChangedListener(this);
	}

	public void addFragmentA(View view) {

		FragmentA fragmentA = new FragmentA();

		FragmentTransaction transaction = manager.beginTransaction();
		transaction.add(R.id.container, fragmentA, "fragA");
//		transaction.addToBackStack("AddFragA");
		transaction.commit();
	}

	public void removeFragmentA(View view) {

		FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("fragA");
		FragmentTransaction transaction = manager.beginTransaction();

		if (fragmentA != null) {
			transaction.remove(fragmentA);
//			transaction.addToBackStack("RemoveFragA");
			transaction.commit();
		} else {
			Toast.makeText(this, "Fragment A not Found", Toast.LENGTH_SHORT).show();
		}
	}

	public void addFragmentB(View view) {

		FragmentB fragmentB = new FragmentB();

		FragmentTransaction transaction = manager.beginTransaction();
		transaction.add(R.id.container, fragmentB, "fragB");
//		transaction.addToBackStack("AddFragB");
		transaction.commit();
	}

	public void removeFragmentB(View view) {

		FragmentB fragmentB = (FragmentB) manager.findFragmentByTag("fragB");
		FragmentTransaction transaction = manager.beginTransaction();

		if (fragmentB != null) {
			transaction.remove(fragmentB);
//			transaction.addToBackStack("RemoveFragB");
			transaction.commit();
		} else {
			Toast.makeText(this, "Fragment B not Found", Toast.LENGTH_SHORT).show();
		}
	}

	public void replaceByFragmentA(View view) {

		FragmentA fragmentA = new FragmentA();
		FragmentTransaction transaction = manager.beginTransaction();
		transaction.replace(R.id.container, fragmentA, "fragA");
//		transaction.addToBackStack("ReplaceByFragA");
		transaction.commit();
	}

	public void replaceByFragmentB(View view) {

		FragmentB fragmentB = new FragmentB();
		FragmentTransaction transaction = manager.beginTransaction();
		transaction.replace(R.id.container, fragmentB, "fragB");
//		transaction.addToBackStack("ReplaceByFragB");
		transaction.commit();
	}

	public void attachFragmentA(View view) {

		FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("fragA");
		FragmentTransaction transaction = manager.beginTransaction();

		if (fragmentA != null) {
			transaction.attach(fragmentA);
//			transaction.addToBackStack("AttachFragA");
			transaction.commit();
		} else {
			Toast.makeText(this, "Fragment A not Found", Toast.LENGTH_SHORT).show();
		}

	}

	public void detachFragmentA(View view) {

		FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("fragA");
		FragmentTransaction transaction = manager.beginTransaction();

		if (fragmentA != null) {
			transaction.detach(fragmentA);
//			transaction.addToBackStack("DetachFragA");
			transaction.commit();
		} else {
			Toast.makeText(this, "Fragment A not Found", Toast.LENGTH_SHORT).show();
		}
	}

	public void showFragmentA(View view) {

		FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("fragA");
		FragmentTransaction transaction = manager.beginTransaction();

		if (fragmentA != null) {
			transaction.show(fragmentA);
//			transaction.addToBackStack("ShowFragA");
			transaction.commit();
		} else {
			Toast.makeText(this, "Fragment A not Found", Toast.LENGTH_SHORT).show();
		}
	}

	public void hideFragmentA(View view) {

		FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("fragA");
		FragmentTransaction transaction = manager.beginTransaction();

		if (fragmentA != null) {
			transaction.hide(fragmentA);
//			transaction.addToBackStack("HideFragA");
			transaction.commit();
		} else {
			Toast.makeText(this, "Fragment A not Found", Toast.LENGTH_SHORT).show();
		}
	}

	public void dummyBackButtonClick(View view) {
		// Put codes here...
	}

	public void pop_AddFragA_Inclusive_Transaction(View view) {
		// Put codes here...
	}

	public void pop_AddFragB_Transaction(View view) {
		// Put codes here...
	}
}
