package com.bignerdranch.android.fragmentdemo4;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragmentManager = getSupportFragmentManager();
        mFragmentManager.addOnBackStackChangedListener(this);
    }

    public void addFragmentA(View view) {

        FragmentA fragmentA = new FragmentA();

        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.add(R.id.container, fragmentA, "fragA");
        transaction.addToBackStack("AddFragA");
        transaction.commit();
    }

    public void removeFragmentA(View view) {

        FragmentA fragmentA = (FragmentA) mFragmentManager.findFragmentByTag("fragA");
        FragmentTransaction transaction = mFragmentManager.beginTransaction();

        if (fragmentA != null) {
            transaction.remove(fragmentA);
            transaction.addToBackStack("RemFragA");
            transaction.commit();
        } else {
            Toast.makeText(this, "Fragment A not Found", Toast.LENGTH_SHORT).show();
        }
    }

    public void addFragmentB(View view) {

        FragmentB fragmentB = new FragmentB();

        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.add(R.id.container, fragmentB, "fragB");
        transaction.addToBackStack("AddFragB");
        transaction.commit();
    }

    public void removeFragmentB(View view) {

        FragmentB fragmentB = (FragmentB) mFragmentManager.findFragmentByTag("fragB");
        FragmentTransaction transaction = mFragmentManager.beginTransaction();

        if (fragmentB != null) {
            transaction.remove(fragmentB);
            transaction.addToBackStack("RemFragB");
            transaction.commit();
        } else {
            Toast.makeText(this, "Fragment B not Found", Toast.LENGTH_SHORT).show();
        }
    }

    public void replaceByFragmentA(View view) {

        FragmentA fragmentA = new FragmentA();
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.replace(R.id.container, fragmentA, "fragA");
        transaction.addToBackStack("RepByFragA");
        transaction.commit();
    }

    public void replaceByFragmentB(View view) {

        FragmentB fragmentB = new FragmentB();
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.replace(R.id.container, fragmentB, "fragB");
        transaction.addToBackStack("RepByFragB");
        transaction.commit();
    }

    public void attachFragmentA(View view) {

        FragmentA fragmentA = (FragmentA) mFragmentManager.findFragmentByTag("fragA");
        FragmentTransaction transaction = mFragmentManager.beginTransaction();

        if (fragmentA != null) {
            transaction.attach(fragmentA);
            transaction.addToBackStack("AttachFragA");
            transaction.commit();
        } else {
            Toast.makeText(this, "Fragment A not Found", Toast.LENGTH_SHORT).show();
        }
    }

    public void detachFragmentA(View view) {

        FragmentA fragmentA = (FragmentA) mFragmentManager.findFragmentByTag("fragA");
        FragmentTransaction transaction = mFragmentManager.beginTransaction();

        if (fragmentA != null) {
            transaction.detach(fragmentA);
            transaction.addToBackStack("DetachFragA");
            transaction.commit();
        } else {
            Toast.makeText(this, "Fragment A not Found", Toast.LENGTH_SHORT).show();
        }
    }

    public void showFragmentA(View view) {

        FragmentA fragmentA = (FragmentA) mFragmentManager.findFragmentByTag("fragA");
        FragmentTransaction transaction = mFragmentManager.beginTransaction();

        if (fragmentA != null) {
            transaction.show(fragmentA);
            transaction.addToBackStack("ShowFragA");
            transaction.commit();
        } else {
            Toast.makeText(this, "Fragment A not Found", Toast.LENGTH_SHORT).show();
        }
    }

    public void hideFragmentA(View view) {

        FragmentA fragmentA = (FragmentA) mFragmentManager.findFragmentByTag("fragA");
        FragmentTransaction transaction = mFragmentManager.beginTransaction();

        if (fragmentA != null) {
            transaction.hide(fragmentA);
            transaction.addToBackStack("HideFragA");
            transaction.commit();
        } else {
            Toast.makeText(this, "Fragment A not Found", Toast.LENGTH_SHORT).show();
        }
    }


    public void dummyBackButtonClick(View view) {
        mFragmentManager.popBackStack();
    }

    public void pop_AddFragA_Inclusive_Transaction(View view) {
        mFragmentManager.popBackStack("AddFragA", FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

    public void pop_AddFragB_Transaction(View view) {
        mFragmentManager.popBackStack("AddFragB", 0);

    }

    @Override
    public void onBackStackChanged() {

        int length = mFragmentManager.getBackStackEntryCount();

        StringBuilder msg = new StringBuilder("");

        for (int i = length - 1; i >= 0; i--) {
            msg.append("Index ").append(i).append(" : ");
            msg.append(mFragmentManager.getBackStackEntryAt(i).getName());
            msg.append(" \n");
        }

        Log.i(TAG, "\n" + msg.toString() + "\n");

    }

    @Override
    public void onBackPressed() {

        if (mFragmentManager.getBackStackEntryCount() > 0) {
            mFragmentManager.popBackStack();
        } else {
            super.onBackPressed();
        }
        super.onBackPressed();
    }
}
