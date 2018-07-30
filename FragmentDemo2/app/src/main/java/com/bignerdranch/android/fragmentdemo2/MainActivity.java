package com.bignerdranch.android.fragmentdemo2;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MyListener {

    private FragmentManager mManager;
    private TextView mResultTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mManager = getSupportFragmentManager();
        mResultTextView = findViewById(R.id.txvResult);

        addFragmentA();
    }

    private void addFragmentA() {
        FragmentA fragmentA = new FragmentA();
        FragmentTransaction transaction = mManager.beginTransaction();
        transaction.add(R.id.containerFragmentA, fragmentA, "fragA");
        transaction.commit();
    }

    @Override
    public void addTwoNumbers(int num1, int num2) {
        int result = num1 + num2;
        mResultTextView.setText("Result: " + result);
    }
}
