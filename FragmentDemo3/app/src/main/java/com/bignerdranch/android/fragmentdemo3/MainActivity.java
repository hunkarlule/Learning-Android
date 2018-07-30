package com.bignerdranch.android.fragmentdemo3;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MyListener {

    private FragmentManager mManager;
    private int firstNumber, secondNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mManager = getSupportFragmentManager();

        addFragmentA();
        addFragmentB();
    }

    private void addFragmentA() {
        FragmentA fragmentA = new FragmentA();
        FragmentTransaction transaction = mManager.beginTransaction();
        transaction.add(R.id.containerFragmentA, fragmentA, "fragA");
        transaction.commit();
    }

    private void addFragmentB() {
        FragmentB fragmentB = new FragmentB();
        FragmentTransaction transaction = mManager.beginTransaction();
        transaction.add(R.id.containerFragmentB, fragmentB, "fragB");
        transaction.commit();
    }

    @Override
    public void addTwoNumbers(int num1, int num2) {
        this.firstNumber = num1;
        this.secondNumber = num2;

        Toast.makeText(this, "numbers recieved in Activity: " + num1 + " , " + num2, Toast.LENGTH_SHORT).show();

    }


    public void sendDataToFragmentB(View view) {
        FragmentB fragmentB = (FragmentB) mManager.findFragmentByTag("fragB");
        fragmentB.addTwoNumbersInFragmentB(firstNumber, secondNumber);
    }
}
