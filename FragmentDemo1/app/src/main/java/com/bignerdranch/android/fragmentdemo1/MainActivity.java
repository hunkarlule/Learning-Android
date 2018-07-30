package com.bignerdranch.android.fragmentdemo1;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
private EditText mEditTextFirstNumber;
private EditText mEditTextSecondNumber;
FragmentManager mManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mManager = getSupportFragmentManager();
        mEditTextFirstNumber = findViewById(R.id.etFirstNumber);
        mEditTextSecondNumber = findViewById(R.id.etSecondNumber);
    }

    public void sendDataToFragment(View view) {

        int firstNumber = Integer.valueOf(mEditTextFirstNumber.getText().toString());
        int secondNumber = Integer.valueOf(mEditTextSecondNumber.getText().toString());

//        Bundle bundle = new Bundle();
//        bundle.putInt(Constants.FIRST_NUMBER, firstNumber);
//        bundle.putInt(Constants.SECOND_NUMBER, secondNumber);

        FragmentA fragment = new FragmentA();
        fragment.setData(firstNumber, secondNumber);

//        fragment.setArguments(bundle);

        FragmentTransaction transaction = mManager.beginTransaction();
        transaction.add(R.id.containerFragmentA, fragment , "fragA");
        transaction.commit();
    }
}
