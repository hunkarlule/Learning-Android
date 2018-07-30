package com.bignerdranch.android.fragmentdemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    FragmentManager mManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mManager = getSupportFragmentManager();


    }

    public void addFragmentA(View view) {
        FragmentA fragmentA = new FragmentA();
        FragmentTransaction transaction = mManager.beginTransaction();
        transaction.add(R.id.container, fragmentA, "fragA");
        transaction.commit();
    }

    public void removeFragmentA(View view) {
        Fragment fragment = mManager.findFragmentByTag("fragA");
        FragmentTransaction transaction = mManager.beginTransaction();
        if (fragment != null) {
            transaction.remove(fragment);
            transaction.commit();
        } else {
            Toast.makeText(this, "Fragment A not found", Toast.LENGTH_SHORT).show();
        }
    }

    public void addFragmentB(View view) {
        FragmentB fragmentB = new FragmentB();
        FragmentTransaction transaction = mManager.beginTransaction();
        transaction.add(R.id.container, fragmentB, "fragB");
        transaction.commit();
    }

    public void removeFragmentB(View view) {

        Fragment fragment = mManager.findFragmentByTag("fragB");
        FragmentTransaction transaction = mManager.beginTransaction();
        if (fragment != null) {
            transaction.remove(fragment);
            transaction.commit();
        } else {
            Toast.makeText(this, "Fragment B not found", Toast.LENGTH_SHORT).show();
        }
    }

    public void replaceByFragmentA(View view) {
        Fragment fragment = new FragmentA();
        FragmentTransaction transaction = mManager.beginTransaction();
        transaction.replace(R.id.container, fragment, "fragA");
        transaction.commit();
    }

    public void replaceByFragmentB(View view) {
        Fragment fragment = new FragmentB();
        FragmentTransaction transaction = mManager.beginTransaction();
        transaction.replace(R.id.container, fragment, "fragB");
        transaction.commit();
    }

    public void attachFragmentA(View view) {

        Fragment fragment = mManager.findFragmentByTag("fragA");
        FragmentTransaction transaction = mManager.beginTransaction();
        if (fragment != null) {
            transaction.attach(fragment);
            transaction.commit();
        } else {
            Toast.makeText(this, "Fragment A not found", Toast.LENGTH_SHORT).show();
        }
    }

    public void detachFragmentA(View view) {

        Fragment fragment = mManager.findFragmentByTag("fragA");
        FragmentTransaction transaction = mManager.beginTransaction();
        if (fragment != null) {
            transaction.detach(fragment);
            transaction.commit();
        } else {
            Toast.makeText(this, "Fragment A not found", Toast.LENGTH_SHORT).show();
        }
    }

    public void showFragmentA(View view) {

        Fragment fragment = mManager.findFragmentByTag("fragA");
        FragmentTransaction transaction = mManager.beginTransaction();
        if (fragment != null) {
            transaction.show(fragment);
            transaction.commit();
        } else {
            Toast.makeText(this, "Fragment A not found", Toast.LENGTH_SHORT).show();
        }
    }

    public void hideFragmentA(View view) {

        Fragment fragment = mManager.findFragmentByTag("fragA");
        FragmentTransaction transaction = mManager.beginTransaction();
        if (fragment != null) {
            transaction.hide(fragment);
            transaction.commit();
        } else {
            Toast.makeText(this, "Fragment A not found", Toast.LENGTH_SHORT).show();
        }
    }
}
